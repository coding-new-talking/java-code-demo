package org.cnt.java.classfile.bytecode;

/**
 * @author lixinjie
 * @since 2019-07-10
 */
public class ByteCode {

	private Magic magic;
	private MinorVersion minorVersion;
	private MajorVersion majorVersion;
	private ConstantPoolCount constantPoolCount;
	private ConstantPool constantPool;
	private AccessFlags accessFlags;
	private ThisClass thisClass;
	private SuperClass superClass;
	private InterfacesCount interfacesCount;
	private Interfaces interfaces;
	private FieldsCount fieldsCount;
	private Fields fields;
	private MethodsCount methodsCount;
	private Methods methods;
	private AttributesCount attributesCount;
	
	private int offset;
	private byte[] bytes;
	
	public ByteCode(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public void parse() {
		parseMagic();
		parseMinorVersion();
		parseMajorVersion();
		parseConstantPoolCount();
		parseConstantPool();
		parseAccessFlags();
		parseThisClass();
		parseSuperClass();
		parseInterfacesCount();
		parseInterfaces();
		parseFieldsCount();
		parseFields();
		parseMethodsCount();
		parseMethods();
	}
	
	public void toString(StringBuilder sb) {
		sb.append(magic).append("\r\n");
		sb.append(minorVersion).append("\r\n");
		sb.append(majorVersion).append("\r\n");
		sb.append(constantPoolCount).append("\r\n");
		sb.append(constantPool).append("\r\n");
		sb.append(accessFlags).append("\r\n");
		sb.append(thisClass).append("\r\n");
		sb.append(superClass).append("\r\n");
		sb.append(interfacesCount).append("\r\n");
		sb.append(interfaces).append("\r\n");
		sb.append(fieldsCount).append("\r\n");
		sb.append(fields).append("\r\n");
		sb.append(methodsCount).append("\r\n");
		sb.append(methods).append("\r\n");
	}
	
	public void parseMagic() {
		magic = new Magic(bytes, offset);
		offset = magic.parse();
	}
	
	public void parseMinorVersion() {
		minorVersion = new MinorVersion(bytes, offset);
		offset = minorVersion.parse();
	}
	
	public void parseMajorVersion() {
		majorVersion = new MajorVersion(bytes, offset);
		offset = majorVersion.parse();
	}
	
	public void parseConstantPoolCount() {
		constantPoolCount = new ConstantPoolCount(bytes, offset);
		offset = constantPoolCount.parse();
	}
	
	public void parseConstantPool() {
		constantPool = new ConstantPool(bytes, offset, constantPoolCount.getCount());
		offset = constantPool.parse();
	}
	
	public void parseAccessFlags() {
		accessFlags = new AccessFlags(bytes, offset);
		offset = accessFlags.parse();
	}
	
	public void parseThisClass() {
		thisClass = new ThisClass(bytes, offset);
		offset = thisClass.parse();
	}
	
	public void parseSuperClass() {
		superClass = new SuperClass(bytes, offset);
		offset = superClass.parse();
	}
	
	public void parseInterfacesCount() {
		interfacesCount = new InterfacesCount(bytes, offset);
		offset = interfacesCount.parse();
	}
	
	public void parseInterfaces() {
		interfaces = new Interfaces(bytes, offset, interfacesCount.getCount());
		offset = interfaces.parse();
	}
	
	public void parseFieldsCount() {
		fieldsCount = new FieldsCount(bytes, offset);
		offset = fieldsCount.parse();
	}
	
	public void parseFields() {
		fields = new Fields(bytes, offset, fieldsCount.getCount(), constantPool);
		offset = fields.parse();
	}
	
	public void parseMethodsCount() {
		methodsCount = new MethodsCount(bytes, offset);
		offset = methodsCount.parse();
	}
	
	public void parseMethods() {
		methods = new Methods(bytes, offset, methodsCount.getCount(), constantPool);
		offset = methods.parse();
	}
	
	public void parseAttributesCount() {
		attributesCount = new AttributesCount(bytes, offset);
		offset = attributesCount.parse();
	}
}
