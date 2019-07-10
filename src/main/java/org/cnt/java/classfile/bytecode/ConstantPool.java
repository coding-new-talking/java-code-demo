package org.cnt.java.classfile.bytecode;

import org.cnt.java.utils.Byter;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class ConstantPool {

	private ConstantPoolCount constantPoolCount;
	
	private int index;
	private byte[] bytes;
	
	private ConstantEntry[] constantEntries;
	
	public ConstantPool(byte[] bytes) {
		this.bytes = bytes;
		this.constantPoolCount = new ConstantPoolCount(bytes);
	}
	
	public int parse() {
		index = constantPoolCount.parse();
		int count = constantPoolCount.count;
		constantEntries = new ConstantEntry[count];
		//第0个位置不使用，从第1个位置开始
		constantEntries[0] = null;
		for (int i = 1; i < count; i++) {
			ConstantEntry entry = ConstantEntryBuilder.build(bytes, index);
			index = entry.parse();
			constantEntries[i] = entry;
		}
		return index;
	}
	
	static class ConstantPoolCount {
		public int offset = 8;
		public int length = 2;
		
		private byte[] bytes;
		
		private int count;
		
		public ConstantPoolCount(byte[] bytes) {
			this.bytes = bytes;
		}
		
		public int parse() {
			count = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class ConstantClass extends ConstantEntry {
	
		private NameIndex nameIndex;
		
		public ConstantClass(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			nameIndex = new NameIndex(bytes, index);
			index = nameIndex.parse();
			return index;
		}
	}
	
	static class ConstantFieldRef extends ConstantEntry {
		
		private ClassIndex classIndex;
		private NameAndTypeIndex nameAndTypeIndex;
		
		public ConstantFieldRef(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			classIndex = new ClassIndex(bytes, index);
			index = classIndex.parse();
			nameAndTypeIndex = new NameAndTypeIndex(bytes, index);
			index = nameAndTypeIndex.parse();
			return index;
		}
	}
	
	static class ConstantMethodRef extends ConstantEntry {
		
		private ClassIndex classIndex;
		private NameAndTypeIndex nameAndTypeIndex;
		
		public ConstantMethodRef(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			classIndex = new ClassIndex(bytes, index);
			index = classIndex.parse();
			nameAndTypeIndex = new NameAndTypeIndex(bytes, index);
			index = nameAndTypeIndex.parse();
			return index;
		}
	}
	
	static class ConstantInterfaceMethodRef extends ConstantEntry {
		
		private ClassIndex classIndex;
		private NameAndTypeIndex nameAndTypeIndex;
		
		public ConstantInterfaceMethodRef(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			classIndex = new ClassIndex(bytes, index);
			index = classIndex.parse();
			nameAndTypeIndex = new NameAndTypeIndex(bytes, index);
			index = nameAndTypeIndex.parse();
			return index;
		}
	}
	
	static class ConstantString extends ConstantEntry {
		
		private StringIndex stringIndex;
		
		public ConstantString(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			stringIndex = new StringIndex(bytes, index);
			index = stringIndex.parse();
			return index;
		}
	}
	
	static class ConstantInteger extends ConstantEntry {
		
		private Bytes4 bytes4;
		
		public ConstantInteger(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			bytes4 = new Bytes4(bytes, index);
			index = bytes4.parse();
			return index;
		}
	}
	
	static class ConstantFloat extends ConstantEntry {
		
		private Bytes4 bytes4;
		
		public ConstantFloat(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			bytes4 = new Bytes4(bytes, index);
			index = bytes4.parse();
			return index;
		}
	}
	
	static class ConstantLong extends ConstantEntry {
		
		private Bytes4 highBytes4;
		private Bytes4 lowBytes4;
		
		public ConstantLong(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			highBytes4 = new Bytes4(bytes, index);
			index = highBytes4.parse();
			lowBytes4 = new Bytes4(bytes, index);
			index = lowBytes4.parse();
			return index;
		}
	}
	
	static class ConstantDouble extends ConstantEntry {
		
		private Bytes4 highBytes4;
		private Bytes4 lowBytes4;
		
		public ConstantDouble(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			highBytes4 = new Bytes4(bytes, index);
			index = highBytes4.parse();
			lowBytes4 = new Bytes4(bytes, index);
			index = lowBytes4.parse();
			return index;
		}
	}
	
	static class ConstantNameAndType extends ConstantEntry {
		
		private NameIndex nameIndex;
		private DescriptorIndex descriptorIndex;
		
		public ConstantNameAndType(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			nameIndex = new NameIndex(bytes, index);
			index = nameIndex.parse();
			descriptorIndex = new DescriptorIndex(bytes, index);
			index = descriptorIndex.parse();
			return index;
		}
	}
	
	static class ConstantUtf8 extends ConstantEntry {
		
		private Length _length;
		private ByteStr byteStr;
		
		public ConstantUtf8(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			_length = new Length(bytes, index);
			index = _length.parse();
			byteStr = new ByteStr(bytes, index, _length._length);
			index = byteStr.parse();
			return index;
		}
	}
	
	static class ConstantMethodHandle extends ConstantEntry {
		
		private ReferenceKind referenceKind;
		private ReferenceIndex referenceIndex;
		
		public ConstantMethodHandle(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			referenceKind = new ReferenceKind(bytes, index);
			index = referenceKind.parse();
			referenceIndex = new ReferenceIndex(bytes, index);
			index = referenceIndex.parse();
			return index;
		}
	}
	
	static class ConstantMethodType extends ConstantEntry {
		
		private DescriptorIndex descriptorIndex;
		
		public ConstantMethodType(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			descriptorIndex = new DescriptorIndex(bytes, index);
			index = descriptorIndex.parse();
			return index;
		}
	}
	
	static class ConstantInvokeDynamic extends ConstantEntry {
		
		private BootstrapMethodAttrIndex bootstrapMethodAttrIndex;
		private NameAndTypeIndex nameAndTypeIndex;
		
		public ConstantInvokeDynamic(byte[] bytes, int offset) {
			super(bytes, offset);
		}
		
		public int parse() {
			index = tag.parse();
			bootstrapMethodAttrIndex = new BootstrapMethodAttrIndex(bytes, index);
			index = bootstrapMethodAttrIndex.parse();
			nameAndTypeIndex = new NameAndTypeIndex(bytes, index);
			index = nameAndTypeIndex.parse();
			return index;
		}
	}
	
	static class Tag {
		public int offset;
		public int length = 1;
		
		private byte[] bytes;
		
		private int tag;
		
		public Tag(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			tag = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class NameIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int nameIndex;
		
		public NameIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			nameIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class ClassIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int classIndex;
		
		public ClassIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			classIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class NameAndTypeIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int nameAndTypeIndex;
		
		public NameAndTypeIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			nameAndTypeIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class StringIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int stringIndex;
		
		public StringIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			stringIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class DescriptorIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int descriptorIndex;
		
		public DescriptorIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			descriptorIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class Bytes4 {
		public int offset;
		public int length = 4;
		
		private byte[] bytes;
		
		private byte byte0;
		private byte byte1;
		private byte byte2;
		private byte byte3;
		
		public Bytes4(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			byte0 = bytes[offset + 0];
			byte1 = bytes[offset + 1];
			byte2 = bytes[offset + 2];
			byte3 = bytes[offset + 3];
			return offset + length;
		}
	}
	
	static class Length {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int _length;
		
		public Length(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			_length = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class ByteStr {
		public int offset;
		public int length;
		
		private byte[] bytes;
		
		private String str;
		
		public ByteStr(byte[] bytes, int offset, int length) {
			this.bytes = bytes;
			this.offset = offset;
			this.length = length;
		}
		
		public int parse() {
			str = Byter.toString(bytes, offset, length);
			return offset + length;
		}
	}
	

	static class ReferenceKind {
		public int offset;
		public int length = 1;
		
		private byte[] bytes;
		
		private int referenceKind;
		
		public ReferenceKind(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			referenceKind = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class ReferenceIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int referenceIndex;
		
		public ReferenceIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			referenceIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static class BootstrapMethodAttrIndex {
		public int offset;
		public int length = 2;
		
		private byte[] bytes;
		
		private int bootstrapMethodAttrIndex;
		
		public BootstrapMethodAttrIndex(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.offset = offset;
		}
		
		public int parse() {
			bootstrapMethodAttrIndex = Byter.toUnsigned(bytes, offset, length);
			return offset + length;
		}
	}
	
	static abstract class ConstantEntry {
		
		protected Tag tag;
		
		protected int index;
		protected byte[] bytes;
		
		public ConstantEntry(byte[] bytes, int offset) {
			this.bytes = bytes;
			this.tag = new Tag(bytes, offset);
		}
		
		public abstract int parse();
	}
	
	static class ConstantEntryBuilder {
		
		public static final int ConstantClass_Tag = 7;
		public static final int ConstantFieldRef_Tag = 9;
		public static final int ConstantMethodRef_Tag = 10;
		public static final int ConstantInterfaceMethodRef_Tag = 11;
		public static final int ConstantString_Tag = 8;
		public static final int ConstantInteger_Tag = 3;
		public static final int ConstantFloat_Tag = 4;
		public static final int ConstantLong_Tag = 5;
		public static final int ConstantDouble_Tag = 6;
		public static final int ConstantNameAndType_Tag = 12;
		public static final int ConstantUtf8_Tag = 1;
		public static final int ConstantMethodHandle_Tag = 15;
		public static final int ConstantMethodType_Tag = 16;
		public static final int ConstantInvokeDynamic_Tag = 18;
		
		public static ConstantEntry build(byte[] bytes, int offset) {
			int tag = Byter.toUnsigned(bytes[offset]);
			switch (tag) {
				case ConstantClass_Tag:
					return new ConstantClass(bytes, offset);
				case ConstantFieldRef_Tag:
					return new ConstantFieldRef(bytes, offset);
				case ConstantMethodRef_Tag:
					return new ConstantMethodRef(bytes, offset);
				case ConstantInterfaceMethodRef_Tag:
					return new ConstantInterfaceMethodRef(bytes, offset);
				case ConstantString_Tag:
					return new ConstantString(bytes, offset);
				case ConstantInteger_Tag:
					return new ConstantInteger(bytes, offset);
				case ConstantFloat_Tag:
					return new ConstantFloat(bytes, offset);
				case ConstantLong_Tag:
					return new ConstantLong(bytes, offset);
				case ConstantDouble_Tag:
					return new ConstantDouble(bytes, offset);
				case ConstantNameAndType_Tag:
					return new ConstantNameAndType(bytes, offset);
				case ConstantUtf8_Tag:
					return new ConstantUtf8(bytes, offset);
				case ConstantMethodHandle_Tag:
					return new ConstantMethodHandle(bytes, offset);
				case ConstantMethodType_Tag:
					return new ConstantMethodType(bytes, offset);
				case ConstantInvokeDynamic_Tag:
					return new ConstantInvokeDynamic(bytes, offset);
			}
			return null;
		}
	}
}
