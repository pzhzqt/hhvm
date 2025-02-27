// Copyright (c) Facebook, Inc. and its affiliates.
//
// This source code is licensed under the MIT license found in the
// LICENSE file in the "hack" directory of this source tree.

use eq_modulo_pos::EqModuloPos;
use no_pos_hash::NoPosHash;
use ocamlrep_derive::FromOcamlRep;
use ocamlrep_derive::FromOcamlRepIn;
use ocamlrep_derive::ToOcamlRep;
use serde::Deserialize;
use serde::Serialize;

#[derive(
    Copy,
    Clone,
    Debug,
    Deserialize,
    Eq,
    EqModuloPos,
    Hash,
    NoPosHash,
    Ord,
    PartialEq,
    PartialOrd,
    FromOcamlRep,
    FromOcamlRepIn,
    ToOcamlRep,
    Serialize
)]
pub struct TanySentinel;

arena_deserializer::impl_deserialize_in_arena!(TanySentinel);

impl arena_trait::TrivialDrop for TanySentinel {}
