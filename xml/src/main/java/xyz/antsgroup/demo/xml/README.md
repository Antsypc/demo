XML
===
本文主要包括XML,DTD,XML Schema的相关基本知识.

## XML语法
- 声明头规范示例: `<?xml version="1.0" encoding="UTF-8" ?>`
- 标签:<></> 或 </>.
- 属性: 必须用引号,单双引号都可以.
- 命名: 不能以`xml`,`XML`,`Xml`开头,不能有空格.
- 5个保留字使用符号: < `&lt;`, > `&gt;`, & `&amp;`, ' `&apos;`, " `&quot;`.
 
XML命名空间

    <?xml version="1.0" encoding="ISO-8859-1"?>
    <html xmlns="http://www.w3.org/1999/xhtml"  <!-- xmlns后直接是URI表示默认命名空间,如果没有特殊说明,其子标签都使用该命名空间 -->
        xmlns:xlink="http://www.w3.org/1999/xlink"> <!-- xmlns后接前缀,表示为命名空间取别名 -->
    <body>
      <h2>My CD Collection</h2>
      <table border="1">
        <tr>
          <th align="left">Title</th>   <!-- 标签或属性前没有前缀,表示使用默认命名空间的标签或属性 -->
          <th align="left">Artist</th>
        </tr>
        <xlink:for-each select="catalog/cd">
        <tr>
          <td><xlink:select="title"/></td>  <!-- 使用xlink中select属性 -->
          <td><xlink:select="artist"/></td>
        </tr>
        </xlink:for-each>
      </table>
    </body>
    </html>
    
## DTD - Document Type Definition
### XML DTD 声明
在XML内部声明,例如:

    <?xml version="1.0"?>
    <book>
        <name> XML </name>
        <author> Peter </author>
    </book>
    
如要在第一行后添加:

    <!DOCTYPE book [
        <!ELEMENT book(name, author)>
        <!ELEMENT book (#PCDATA)>
        <!ELEMENT author (#PCDATA)>
    ]>
    
使用外部DTD声明可以被多个XML文件引用,文件以`.dtd`结尾.如对上述改写为 book.dtd

    <!ELEMENT book(name, author)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT author (#PCDATA)>

调用方式:

    <?xml version="1.0"?>
    <!DOCTYPE book SYSTEM "book.dtd">   <!-- 根元素book,SYSTEM表示私有是个人或组织创建的,PUBLIC表示权威机构通用的 -->
    <book>
        <name> XML </name>
        <author> Peter </author>
    </book>
    
### DTD 语法
#### 元素声明
下面声明表示,book子元素必须按照 name, author的顺序出现, name 可以出现1次或0次,author至少出现一次.其他支持的正则符号还有:(),|,*.

    <!ELEMENT book(name?, author+)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT author (#PCDATA)>

空元素表示法

    <!ELEMENT br EMPTY>
    比如: <br />
    
Unrestricted 元素表示该元素的内容可以是任意形式,一般用于根元素,这样比较灵活:

    <!ELEMENT book ANY>

简单元素,除了不能包含子元素,其他任何数据字符都可以:

    <!ELEMENT name (#PCDATA)>
    
混合类型

    <!ELEMENT name (#PCDATA|name)*>
    
#### 属性声明

    <!ATTLIST 元素名称 属性名称 属性类型 属性值>
    例子:
    <!ATTLIST book press CDATA #FIXED "清华出版社">

| 属性类型         | 描述 |
|----------------|------|
| CDATA           | 值为字符数据 (character data) |
| (en1\|en2\|..)	| 此值是枚举列表中的一个值 |
| ID	            | 值为唯一的 id,区分相同结构相同属性的不同元素 |
| IDREF	        | 值为另外一个元素的 id |
| IDREFS	        | 值为其他 id 的列表,用空格隔开 |
| NMTOKEN	        | 值为合法的 XML 名称 |
| NMTOKENS	    | 值为合法的 XML 名称的列表,用空格隔开 |
| ENTITY	        | 值是一个已知实体 |
| ENTITIES	    | 值是一个实体列表 |
| NOTATION	    | 值为DTD中声明的符号,对非XML格式数据很有用,如图片 |
| xml	        | 值是一个预定义的 XML 值 |


| 属性值	       | 描述|
|--------------|-----|
| abc           | 属性的默认值是abc |
| #REQUIRED	    | 属性值是必需的|
| #IMPLIED	    | 属性不是必需的|
| #FIXED value	| 属性值是固定为value|

#### 实体声明
实体类似于宏定义.

内部实体就是一个字符串内容.

    <!-- 定义 -->
    <!ENTITY writer "Peter">
    <!ENTITY copyright "Copyright w3c">
    
    <!-- 调用. 以&开始,以;结束 -->
    <author>&writer;&copyright;</author>
    
外部实体不是文字内容,而是外部文件,该文件允许是字符或二进制.如果是文本,在调用是直接插入,如果是二进制,则作为属性使用.

    <!-- DTD -->
    <!ENTITY writer SYSTEM "http://www.w3chtml.com/dtd/entities.dtd">
    <!ENTITY copyright SYSTEM "http://www.w3chtml.com/dtd/entities.dtd">
    <!-- 调用 -->
    <author>&writer;&copyright;</author>
    
## XML Schema(XSD)
- 定义可出现在文档中的元素
- 定义可出现在文档中的属性
- 定义哪个元素是子元素
- 定义子元素的次序
- 定义子元素的数目
- 定义元素是否为空，或者是否可包含文本
- 定义元素和属性的数据类型
- 定义元素和属性的默认值以及固定值
- XML Schema 可针对未来的需求进行扩展
- XML Schema 更完善功能更强大
- XML Schema 基于 XML 编写
- XML Schema 支持数据类型
- XML Schema 支持命名空间

例子,对上面 DTD 改写成 Schema 为:

    <?xml version="1.0"?>
    <xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema"
    targetNamespace="http://www.w3school.com.cn"
    xmlns="http://www.w3school.com.cn"
    elementFormDefault="qualified">
    
        <xs:element name="book">
            <xs:complexType>
              <xs:sequence>
        	    <xs:element name="name" type="xs:string"/>
        	    <xs:element name="author" type="xs:string"/>
              </xs:sequence>
            </xs:complexType>
        </xs:element>
    
    </xs:schema>
    
### XSD 数据类型

|XSDd 原始数据类型     | 描述 |
|--------------------|-----|
| string             |   |        
| boolean            |   |       
| decimal            | 十进制数  |       
| float              |   |   
| double             |   |       
| timeDuration       | 持续时间 |           
| dateTime           |   |       
| time               |   |   
| date               |   |   
| anyURL             |   |       
| recurringDuration  | 一定时间间隔后重现的持续时间  |  

|XSDd 派生数据类型     | 描述 |
|--------------------|-----|
|integer             |  |           
|long                | -263~262 |       
|nonNegativeInteger  |  |                   
|positiveInteger     |  |                   
|int                 | -231~230 |       
|time                |  |       
|date                |  | 

|simpleType元素常用属性 | 描述 |
|---------------------|------|
| enumeration      |  |     
| fractionDigits   | 限定最大小数位 |         
| length           |  | 
| maxExclusive     | 数据最大值(小于) |     
| maxInclusive     | 数据最大值(小于或等于) |     
| maxLength        |  | 
| minExclusive     |  |     
| minInclusive     |  |     
| minLength        |  | 
| pattern          |  | 

自定义数据类型示例

    <xs:element name="bookname">
    <xs:simpleType> <!-- 自定义数据类型名字 -->
        <xs:restriction base="xs:string">   <!-- restriction表示下面的是对bookname这个element的限定base,基于的数据类型 -->
            <xs:minLength value="5"/>
            <xs:maxLength value="10"/>
        </xs:restriction>
    </xs:simpleType>
    </xs:element>

### XSD 元素声明
基本格式

    <xs:element name="" type="" default="" minOccurs="元素出现的最小次数" maxOccurs=""/>

对如下 xml:

    <book>
        <bookname>iron</bookname>
        <description>iron man</description>
        <price>33</price>
    </book>

对应XSD声明,这是一个有子元素的元素,所以下面这种形式是复杂元素的声明:

    <xs:element name="book">
      <xs:complexType>
        <xs:sequence>
          <xs:element name="bookname" type="xs:string"/>    <!-- 该元素没有子元素,就是一般声明格式 -->
          <xs:element name="description" type="xs:string"/>
          <xs:element name="price" type="positiveInteger"/>
        </xs:sequence>
      </xs:complexType>
    </xs:element>
    
如果以元素需要复用另一元素的子元素:

<xs:complexType name="book-ex">
  <xs:complexContent>
    <xs:extension base="book">
      <xs:sequence>
        <xs:element name="press" type="xs:string"/>
        <xs:element name="ISBN" type="xs:positiveInteger"/>
      </xs:sequence>
    </xs:extension>
  </xs:complexContent>
</xs:complexType>

### XSD 属性声明

    <xs:attribute name="" type="" use="optional | required | prohibited | default | fixed" default="" fixed=""/>
    
### XSD 指示器