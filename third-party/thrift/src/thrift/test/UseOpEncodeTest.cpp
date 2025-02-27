/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#include <folly/portability/GTest.h>
#include <thrift/conformance/cpp2/internal/AnyStructSerializer.h>
#include <thrift/lib/cpp/util/EnumUtils.h>
#include <thrift/lib/cpp2/protocol/Object.h>
#include <thrift/test/gen-cpp2/UseOpEncode_types.h>

// TODO: Remove this. Specify namespace explicitly instead.
using namespace ::apache::thrift::conformance;

using detail::protocol_reader_t;
using detail::protocol_writer_t;

namespace apache::thrift::test {

template <StandardProtocol Protocol>
void testUseOpEncode() {
  SCOPED_TRACE(apache::thrift::util::enumNameSafe(Protocol));
  protocol_writer_t<Protocol> writer;
  folly::IOBufQueue queue;
  writer.setOutput(&queue);
  OpEncodeStruct original;
  Foo foo;
  foo.field() = 3;
  original.foo_field() = foo;
  original.int_field() = 5;
  original.enum_field() = Enum::first;
  auto adaptedFoo = test::TemplatedTestAdapter::fromThrift(foo);
  original.adapted_field() = adaptedFoo;
  original.list_field().emplace().push_back(adaptedFoo);
  original.list_shared_ptr_field() =
      std::make_shared<std::vector<test::Wrapper<Foo>>>(
          original.list_field().value());
  original.list_cpp_type_field().emplace().push_back(adaptedFoo);
  original.set_field().emplace().insert(adaptedFoo);
  original.map_field().emplace()[adaptedFoo] = adaptedFoo;
  original.nested_field().emplace()[1] = original.list_field().value();
  original.bar_field().emplace().list_field() = original.list_field().value();

  auto adaptedInt = test::TemplatedTestAdapter::fromThrift(1);
  original.adapted_int_field() = adaptedInt;
  original.list_int_field().emplace().push_back(adaptedInt);
  original.meta_ref() = "some metadata";
  original.adapted_list_field()->value.push_back(adaptedFoo);

  original.write(&writer);

  protocol_reader_t<Protocol> reader;
  auto serialized = queue.move();
  reader.setInput(serialized.get());
  OpEncodeStruct result;
  result.read(&reader);
  EXPECT_EQ(result, original);

  // Test whether field adapter is used
  EXPECT_EQ(result.adapted_list_field()->fieldId, 14);
  EXPECT_EQ(*result.adapted_list_field()->meta, "some metadata");
}

TEST(UseOpEncodeTest, UseOpEncode) {
  testUseOpEncode<StandardProtocol::Binary>();
  testUseOpEncode<StandardProtocol::Compact>();
}

template <StandardProtocol Protocol>
void testSerializedSize() {
  SCOPED_TRACE(apache::thrift::util::enumNameSafe(Protocol));
  protocol_writer_t<Protocol> writer;
  // Construct BazWithUseOpEncode and Baz such that they have the same
  // serialized data.
  BazWithUseOpEncode bazWithUseOpEncode;
  Baz baz;
  bazWithUseOpEncode.int_field() = 5;
  baz.int_field() = 5;
  bazWithUseOpEncode.enum_field() = Enum::second;
  baz.enum_field() = Enum::second;
  Foo foo;
  foo.field() = 3;
  auto adaptedFoo = test::TemplatedTestAdapter::fromThrift(foo);
  bazWithUseOpEncode.adapted_field() = adaptedFoo;
  baz.adapted_field() = adaptedFoo;
  bazWithUseOpEncode.list_field().emplace().push_back(adaptedFoo);
  baz.list_field().emplace().push_back(foo);
  bazWithUseOpEncode.map_field().emplace()[3] = adaptedFoo;
  baz.map_field().emplace()[3] = foo;
  bazWithUseOpEncode.list_shared_ptr_field() =
      std::make_shared<std::vector<test::Wrapper<Foo>>>(
          bazWithUseOpEncode.list_field().value());
  baz.list_shared_ptr_field() =
      std::make_shared<std::vector<Foo>>(baz.list_field().value());

  auto size = bazWithUseOpEncode.serializedSize(&writer);
  auto expected = baz.serializedSize(&writer);
  EXPECT_EQ(size, expected);
}

TEST(UseOpEncodeTest, SerializedSize) {
  testSerializedSize<StandardProtocol::Binary>();
  testSerializedSize<StandardProtocol::Compact>();
}
} // namespace apache::thrift::test
