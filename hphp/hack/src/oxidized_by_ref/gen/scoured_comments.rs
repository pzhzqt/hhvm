// Copyright (c) Facebook, Inc. and its affiliates.
//
// This source code is licensed under the MIT license found in the
// LICENSE file in the "hack" directory of this source tree.
//
// @generated SignedSource<<1a4c47d5bf5a4391f8fdf6d9ff95859d>>
//
// To regenerate this file, run:
//   hphp/hack/src/oxidized_regen.sh

use arena_trait::TrivialDrop;
use no_pos_hash::NoPosHash;
use ocamlrep_derive::FromOcamlRepIn;
use ocamlrep_derive::ToOcamlRep;
use serde::Deserialize;
use serde::Serialize;

#[allow(unused_imports)]
use crate::*;

#[rust_to_ocaml(attr = "deriving (show, eq)")]
pub type Fixmes<'a> = i_map::IMap<'a, i_map::IMap<'a, &'a pos::Pos<'a>>>;

#[derive(
    Clone,
    Debug,
    Deserialize,
    Eq,
    FromOcamlRepIn,
    Hash,
    NoPosHash,
    Ord,
    PartialEq,
    PartialOrd,
    Serialize,
    ToOcamlRep
)]
#[rust_to_ocaml(attr = "deriving (show, eq)")]
#[rust_to_ocaml(prefix = "sc_")]
#[repr(C)]
pub struct ScouredComments<'a> {
    #[serde(deserialize_with = "arena_deserializer::arena", borrow)]
    pub comments: &'a [(&'a pos::Pos<'a>, prim_defs::Comment<'a>)],
    #[serde(deserialize_with = "arena_deserializer::arena", borrow)]
    pub fixmes: &'a Fixmes<'a>,
    #[serde(deserialize_with = "arena_deserializer::arena", borrow)]
    pub misuses: &'a Fixmes<'a>,
    #[serde(deserialize_with = "arena_deserializer::arena", borrow)]
    pub error_pos: &'a [&'a pos::Pos<'a>],
    #[serde(deserialize_with = "arena_deserializer::arena", borrow)]
    pub bad_ignore_pos: &'a [&'a pos::Pos<'a>],
}
impl<'a> TrivialDrop for ScouredComments<'a> {}
arena_deserializer::impl_deserialize_in_arena!(ScouredComments<'arena>);
