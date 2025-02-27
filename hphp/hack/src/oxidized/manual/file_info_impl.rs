// Copyright (c) Facebook, Inc. and its affiliates.
//
// This source code is licensed under the MIT license found in the
// LICENSE file in the "hack" directory of this source tree.

use relative_path::RelativePath;
use rusqlite::types::FromSql;
use rusqlite::types::FromSqlError;
use rusqlite::types::FromSqlResult;
use rusqlite::types::ValueRef;

use crate::gen::file_info::Mode;
use crate::gen::file_info::NameType;
use crate::gen::file_info::Pos;
use crate::gen::naming_types::KindOfType;

impl From<Mode> for parser_core_types::FileMode {
    fn from(mode: Mode) -> Self {
        match mode {
            Mode::Mhhi => Self::Hhi,
            Mode::Mstrict => Self::Strict,
        }
    }
}
impl From<parser_core_types::FileMode> for Mode {
    fn from(mode: parser_core_types::FileMode) -> Self {
        match mode {
            parser_core_types::FileMode::Hhi => Self::Mhhi,
            parser_core_types::FileMode::Strict => Self::Mstrict,
        }
    }
}
impl std::cmp::PartialEq<parser_core_types::FileMode> for Mode {
    fn eq(&self, other: &parser_core_types::FileMode) -> bool {
        self.eq(&Self::from(*other))
    }
}
impl std::cmp::PartialEq<Mode> for parser_core_types::FileMode {
    fn eq(&self, other: &Mode) -> bool {
        self.eq(&Self::from(*other))
    }
}

impl Pos {
    pub fn path(&self) -> &RelativePath {
        match self {
            Pos::Full(pos) => pos.filename(),
            Pos::File(_, path) => path,
        }
    }
}

impl From<KindOfType> for NameType {
    fn from(kind: KindOfType) -> Self {
        match kind {
            KindOfType::TClass => NameType::Class,
            KindOfType::TTypedef => NameType::Typedef,
        }
    }
}

impl FromSql for NameType {
    fn column_result(value: ValueRef<'_>) -> FromSqlResult<Self> {
        match value {
            ValueRef::Integer(i) => {
                if i == NameType::Fun as i64 {
                    Ok(NameType::Fun)
                } else if i == NameType::Const as i64 {
                    Ok(NameType::Const)
                } else if i == NameType::Class as i64 {
                    Ok(NameType::Class)
                } else if i == NameType::Typedef as i64 {
                    Ok(NameType::Typedef)
                } else {
                    Err(FromSqlError::OutOfRange(i))
                }
            }
            _ => Err(FromSqlError::InvalidType),
        }
    }
}

impl rusqlite::ToSql for NameType {
    fn to_sql(&self) -> rusqlite::Result<rusqlite::types::ToSqlOutput<'_>> {
        Ok(rusqlite::types::ToSqlOutput::from(*self as i64))
    }
}
