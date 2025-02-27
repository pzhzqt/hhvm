#
# Autogenerated by Thrift
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#  @generated
#

from libc.stdint cimport (
    int8_t as cint8_t,
    int16_t as cint16_t,
    int32_t as cint32_t,
    int64_t as cint64_t,
    uint32_t as cuint32_t,
)
from libcpp.string cimport string
from libcpp cimport bool as cbool, nullptr, nullptr_t
from cpython cimport bool as pbool
from libcpp.memory cimport shared_ptr, unique_ptr
from libcpp.utility cimport move as cmove
from libcpp.vector cimport vector
from libcpp.set cimport set as cset
from libcpp.map cimport map as cmap, pair as cpair
from thrift.py3.exceptions cimport cTException
cimport folly.iobuf as _fbthrift_iobuf
cimport thrift.py3.exceptions
cimport thrift.py3.types
from thrift.py3.types cimport (
    bstring,
    bytes_to_string,
    field_ref as __field_ref,
    optional_field_ref as __optional_field_ref,
    required_field_ref as __required_field_ref,
    terse_field_ref as __terse_field_ref,
    union_field_ref as __union_field_ref,
    get_union_field_value as __get_union_field_value,
)
from thrift.py3.common cimport (
    RpcOptions as __RpcOptions,
    Protocol as __Protocol,
    cThriftMetadata as __fbthrift_cThriftMetadata,
    MetadataBox as __MetadataBox,
)
from folly.optional cimport cOptional as __cOptional
from folly cimport cFollyTry
from cpython.ref cimport PyObject
from thrift.py3.stream cimport (
    ClientBufferedStream, cClientBufferedStream, cClientBufferedStreamWrapper,
    ResponseAndClientBufferedStream, cResponseAndClientBufferedStream,
    ServerStream, cServerStream, ResponseAndServerStream
)

cimport module.types_fields as _fbthrift_types_fields

cdef extern from "thrift/compiler/test/fixtures/stream/src/gen-py3/module/types.h":
  pass





cdef extern from "thrift/compiler/test/fixtures/stream/src/gen-cpp2/module_metadata.h" namespace "apache::thrift::detail::md":
    cdef cppclass ExceptionMetadata[T]:
        @staticmethod
        void gen(__fbthrift_cThriftMetadata &metadata)
cdef extern from "thrift/compiler/test/fixtures/stream/src/gen-cpp2/module_metadata.h" namespace "apache::thrift::detail::md":
    cdef cppclass StructMetadata[T]:
        @staticmethod
        void gen(__fbthrift_cThriftMetadata &metadata)
cdef extern from "thrift/compiler/test/fixtures/stream/src/gen-cpp2/module_types_custom_protocol.h" namespace "::cpp2":

    cdef cppclass cFooStreamEx "::cpp2::FooStreamEx"(cTException):
        cFooStreamEx() except +
        cFooStreamEx(const cFooStreamEx&) except +
        bint operator==(cFooStreamEx&)
        bint operator!=(cFooStreamEx&)
        bint operator<(cFooStreamEx&)
        bint operator>(cFooStreamEx&)
        bint operator<=(cFooStreamEx&)
        bint operator>=(cFooStreamEx&)


    cdef cppclass cFooEx "::cpp2::FooEx"(cTException):
        cFooEx() except +
        cFooEx(const cFooEx&) except +
        bint operator==(cFooEx&)
        bint operator!=(cFooEx&)
        bint operator<(cFooEx&)
        bint operator>(cFooEx&)
        bint operator<=(cFooEx&)
        bint operator>=(cFooEx&)




cdef class FooStreamEx(thrift.py3.exceptions.GeneratedError):
    cdef shared_ptr[cFooStreamEx] _cpp_obj
    cdef _fbthrift_types_fields.__FooStreamEx_FieldsSetter _fields_setter

    @staticmethod
    cdef _fbthrift_create(shared_ptr[cFooStreamEx])



cdef class FooEx(thrift.py3.exceptions.GeneratedError):
    cdef shared_ptr[cFooEx] _cpp_obj
    cdef _fbthrift_types_fields.__FooEx_FieldsSetter _fields_setter

    @staticmethod
    cdef _fbthrift_create(shared_ptr[cFooEx])




cdef class ClientBufferedStream__i32(ClientBufferedStream):
    cdef unique_ptr[cClientBufferedStreamWrapper[cint32_t]] _gen

    @staticmethod
    cdef _fbthrift_create(cClientBufferedStream[cint32_t]& c_obj, __RpcOptions rpc_options)

    @staticmethod
    cdef void callback(
        cFollyTry[__cOptional[cint32_t]]&& res,
        PyObject* userdata,
    )

cdef class ServerStream__i32(ServerStream):
    pass


cdef class ResponseAndClientBufferedStream__i32_i32(ResponseAndClientBufferedStream):
    cdef ClientBufferedStream__i32 _stream
    cdef cint32_t _response

    @staticmethod
    cdef _fbthrift_create(cResponseAndClientBufferedStream[cint32_t, cint32_t]& c_obj, __RpcOptions rpc_options)


cdef class ResponseAndServerStream__i32_i32(ResponseAndServerStream):
    pass

