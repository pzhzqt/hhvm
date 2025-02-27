/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.basic;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import com.google.common.collect.*;
import java.util.*;
import javax.annotation.Nullable;
import org.apache.thrift.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;
import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.MoreObjects.ToStringHelper;

@SwiftGenerated
@com.facebook.swift.codec.ThriftStruct(value="MyStruct", builder=MyStruct.Builder.class)
public final class MyStruct implements com.facebook.thrift.payload.ThriftSerializable {

    @ThriftConstructor
    public MyStruct(
        @com.facebook.swift.codec.ThriftField(value=1, name="myIntField", requiredness=Requiredness.NONE) final long myIntField,
        @com.facebook.swift.codec.ThriftField(value=2, name="myStringField", requiredness=Requiredness.NONE) final String myStringField
    ) {
        this.myIntField = myIntField;
        this.myStringField = myStringField;
    }
    
    @ThriftConstructor
    protected MyStruct() {
      this.myIntField = 0L;
      this.myStringField = null;
    }
    
    public static class Builder {
    
        private long myIntField = 0L;
        private String myStringField = null;
    
        @com.facebook.swift.codec.ThriftField(value=1, name="myIntField", requiredness=Requiredness.NONE)
        public Builder setMyIntField(long myIntField) {
            this.myIntField = myIntField;
            return this;
        }
    
        public long getMyIntField() { return myIntField; }
    
            @com.facebook.swift.codec.ThriftField(value=2, name="myStringField", requiredness=Requiredness.NONE)
        public Builder setMyStringField(String myStringField) {
            this.myStringField = myStringField;
            return this;
        }
    
        public String getMyStringField() { return myStringField; }
    
        public Builder() { }
        public Builder(MyStruct other) {
            this.myIntField = other.myIntField;
            this.myStringField = other.myStringField;
        }
    
        @ThriftConstructor
        public MyStruct build() {
            MyStruct result = new MyStruct (
                this.myIntField,
                this.myStringField
            );
            return result;
        }
    }
    
    public static final Map<String, Integer> NAMES_TO_IDS = new HashMap();
    public static final Map<String, Integer> THRIFT_NAMES_TO_IDS = new HashMap();
    public static final Map<Integer, TField> FIELD_METADATA = new HashMap<>();
    private static final TStruct STRUCT_DESC = new TStruct("MyStruct");
    private final long myIntField;
    public static final int _MYINTFIELD = 1;
    private static final TField MY_INT_FIELD_FIELD_DESC = new TField("myIntField", TType.I64, (short)1);
        private final String myStringField;
    public static final int _MYSTRINGFIELD = 2;
    private static final TField MY_STRING_FIELD_FIELD_DESC = new TField("myStringField", TType.STRING, (short)2);
    static {
      NAMES_TO_IDS.put("myIntField", 1);
      THRIFT_NAMES_TO_IDS.put("myIntField", 1);
      FIELD_METADATA.put(1, MY_INT_FIELD_FIELD_DESC);
      NAMES_TO_IDS.put("myStringField", 2);
      THRIFT_NAMES_TO_IDS.put("myStringField", 2);
      FIELD_METADATA.put(2, MY_STRING_FIELD_FIELD_DESC);
      com.facebook.thrift.type.TypeRegistry.add(new com.facebook.thrift.type.Type(
        new com.facebook.thrift.type.UniversalName("test.dev/fixtures/no-legacy-apis/MyStruct"), 
        MyStruct.class, MyStruct::read0));
    }
    
    
    @com.facebook.swift.codec.ThriftField(value=1, name="myIntField", requiredness=Requiredness.NONE)
    public long getMyIntField() { return myIntField; }
    
    
    @Nullable
    @com.facebook.swift.codec.ThriftField(value=2, name="myStringField", requiredness=Requiredness.NONE)
    public String getMyStringField() { return myStringField; }
    
    @java.lang.Override
    public String toString() {
        ToStringHelper helper = toStringHelper(this);
        helper.add("myIntField", myIntField);
        helper.add("myStringField", myStringField);
        return helper.toString();
    }
    
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
    
        MyStruct other = (MyStruct)o;
    
        return
            Objects.equals(myIntField, other.myIntField) &&
            Objects.equals(myStringField, other.myStringField) &&
            true;
    }
    
    @java.lang.Override
    public int hashCode() {
        return Arrays.deepHashCode(new java.lang.Object[] {
            myIntField,
            myStringField
        });
    }
    
    
    public static com.facebook.thrift.payload.Reader<MyStruct> asReader() {
      return MyStruct::read0;
    }
    
    public static MyStruct read0(TProtocol oprot) throws TException {
      TField __field;
      oprot.readStructBegin(MyStruct.NAMES_TO_IDS, MyStruct.THRIFT_NAMES_TO_IDS, MyStruct.FIELD_METADATA);
      MyStruct.Builder builder = new MyStruct.Builder();
      while (true) {
        __field = oprot.readFieldBegin();
        if (__field.type == TType.STOP) { break; }
        switch (__field.id) {
        case _MYINTFIELD:
          if (__field.type == TType.I64) {
            long myIntField = oprot.readI64();
            builder.setMyIntField(myIntField);
          } else {
            TProtocolUtil.skip(oprot, __field.type);
          }
          break;
        case _MYSTRINGFIELD:
          if (__field.type == TType.STRING) {
            String myStringField = oprot.readString();
            builder.setMyStringField(myStringField);
          } else {
            TProtocolUtil.skip(oprot, __field.type);
          }
          break;
        default:
          TProtocolUtil.skip(oprot, __field.type);
          break;
        }
        oprot.readFieldEnd();
      }
      oprot.readStructEnd();
      return builder.build();
    }
    
    public void write0(TProtocol oprot) throws TException {
      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(MY_INT_FIELD_FIELD_DESC);
      oprot.writeI64(this.myIntField);
      oprot.writeFieldEnd();
      if (myStringField != null) {
        oprot.writeFieldBegin(MY_STRING_FIELD_FIELD_DESC);
        oprot.writeString(this.myStringField);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }
    
    private static class _MyStructLazy {
        private static final MyStruct _DEFAULT = new MyStruct.Builder().build();
    }
    
    public static MyStruct defaultInstance() {
        return  _MyStructLazy._DEFAULT;
    }
}
