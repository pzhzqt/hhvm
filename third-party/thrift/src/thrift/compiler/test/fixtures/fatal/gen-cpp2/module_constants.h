/**
 * Autogenerated by Thrift for thrift/compiler/test/fixtures/fatal/src/module.thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated @nocommit
 */
#pragma once

#include <thrift/lib/cpp2/gen/module_constants_h.h>

#include "thrift/compiler/test/fixtures/fatal/gen-cpp2/module_types.h"

namespace test_cpp2 { namespace cpp_reflection {

struct module_constants {

  static constexpr ::std::int32_t const constant1_ = static_cast<::std::int32_t>(1357);
  static constexpr ::std::int32_t constant1() {
    return constant1_;
  }

  static constexpr char const * const constant2_ = "hello";
  static constexpr char const * constant2() {
    return constant2_;
  }

  static constexpr ::test_cpp2::cpp_reflection::enum1 const constant3_ = static_cast<::test_cpp2::cpp_reflection::enum1>( ::test_cpp2::cpp_reflection::enum1::field0);
  static constexpr ::test_cpp2::cpp_reflection::enum1 constant3() {
    return constant3_;
  }

  static constexpr ::std::int32_t const constant_with_special_name_ = static_cast<::std::int32_t>(42);
  static constexpr ::std::int32_t constant_with_special_name() {
    return constant_with_special_name_;
  }

};

}} // test_cpp2::cpp_reflection
