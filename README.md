# commerce

# 1.Introduction

Business functions of the project

# 2.Technical selection

[The technical stack of the project, including language, framework, middleware, etc]

Spring Boot 3.2.4

Java version: 17 Oracle OpenJDK version:17.0.8 [must be 17]

# 3.Directory structure

tree command

```bash
commerce
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com
│   │   │   │   ├── group/   
│   │   │   │   │   ├──consult  
│   │   │   │   │   │   ├──commerce
│   │   │   │   │   │   │   ├── annotation/         # annotation class   
│   │   │   │   │   │   │   ├── config/             # related configuration 
│   │   │   │   │   │   │   │   ├── security/       # related class   
│   │   │   │   │   │   │   │   ├── vo/             # vo class   
│   │   │   │   │   │   │   │   ├── entity/         # entity class   
│   │   │   │   │   │   │   ├── controller/         # interface class   
│   │   │   │   │   │   │   ├── persist/                # database class
│   │   │   │   │   │   │   │   ├── entity/         # entity 
│   │   │   │   │   │   │   │   ├── mapper/         # mapper interface 
│   │   │   │   │   │   │   ├── event/              # event package
│   │   │   │   │   │   │   ├── model/              # event package
│   │   │   │   │   │   │   │   ├── basic/          # basic entity 
│   │   │   │   │   │   │   │   ├── constant/       # constant 
│   │   │   │   │   │   │   │   ├── data.object/    # event do
│   │   │   │   │   │   │   │   ├── dto/            # data transfer class 
│   │   │   │   │   │   │   │   ├── enum/           # enum
│   │   │   │   │   │   │   │   ├── vo/             # data return class
│   │   │   │   │   │   │   ├── service/            # internal interface class       
│   │   │   │   │   │   │   │   ├── common/         # internal interface implementation class   
│   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   │   ├── dao/            # internal interface implementation class   
│   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   │   ├── domain/         # internal interface implementation class   
│   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   ├── utils/              # utils class
│   │   │   ├── resources/                    # profile
│   │   │   │   ├── cert/                     # profile
│   │   │   │   ├── metadata/                 # profile
│   │   │   │   ├── sql/                      # profile
│   │   │   │   ├── static/                   # profile

│   ├── test/
│   │   ├── java/
│   │   │   ├── com
│   │   │   │   ├── group/   
│   │   │   │   │   ├──consult  
│   │   │   │   │   │   ├──commerce
│   │   │   │   │   │   │   │   ├── annotation/         # annotation class   
│   │   │   │   │   │   │   │   ├── config/             # related configuration 
│   │   │   │   │   │   │   │   │   ├── security/       # related class   
│   │   │   │   │   │   │   │   │   ├── vo/             # vo class   
│   │   │   │   │   │   │   │   │   ├── entity/         # entity class   
│   │   │   │   │   │   │   │   ├── controller/         # interface class   
│   │   │   │   │   │   │   │   ├── persist/                # database class
│   │   │   │   │   │   │   │   │   ├── entity/         # entity 
│   │   │   │   │   │   │   │   │   ├── mapper/         # mapper interface 
│   │   │   │   │   │   │   │   ├── event/              # event package
│   │   │   │   │   │   │   │   ├── model/              # event package
│   │   │   │   │   │   │   │   │   ├── basic/          # basic entity 
│   │   │   │   │   │   │   │   │   ├── constant/       # constant 
│   │   │   │   │   │   │   │   │   ├── data.object/    # event do
│   │   │   │   │   │   │   │   │   ├── dto/            # data transfer class 
│   │   │   │   │   │   │   │   │   ├── enum/           # enum
│   │   │   │   │   │   │   │   │   ├── vo/             # data return class
│   │   │   │   │   │   │   │   ├── service/            # internal interface class       
│   │   │   │   │   │   │   │   │   ├── common/         # internal interface implementation class   
│   │   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   │   │   ├── dao/            # internal interface implementation class   
│   │   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   │   │   ├── domain/         # internal interface implementation class   
│   │   │   │   │   │   │   │   │   │   ├── impl/       # internal interface implementation class   
│   │   │   │   │   │   │   │   ├── utils/              # utils class
│   │   │   ├── resources/                    # profile
│   │   │   │   ├── cert/                     # profile
│   │   │   │   ├── metadata/                 # profile
│   │   │   │   ├── sql/                      # profile
│   │   │   │   ├── static/                   # profile
├── pom.xml                             # pom dependency
├── README.md                           # project description document
```

# 4.Local Build
[Tools and commands used in the local development process]

	1. setup 17 Oracle OpenJDK version:17.0.8 [must be 17]
    2. setup mysql
    3. import database and relative tables
    4. setup git
    5. git clone ......
    6. setup nodejs 18 +
    7. cd commerce/ && npm i && npm run serve
    8. run the CommerceApplication 
       or cd /commerce && mvn spring-boot:run
    9. access: http://localhost:8080

# 5.Domain model
[Core domain concepts, such as user, product, etc]

# 6.Testing

[Automated Testing]

    
# 7.Technical architecture

    Spring Boot Project + VUE Project

    Spring Boot Project: backend

    VUE Project: frontend

# 8.Deployment architecture
   Git Bucket Deployment architecture

	1.【强制】 请使用自己的git账号进行操作。

	2.【强制】 本次dev环境开发，主分支：dev，新规开发的时候，需要从主分支dev上拉取代码新建分支,新分支命名：feature_功能名。

	3.【强制】 开发完成后，需要对代码提出merge申请，代码经过review完之后，才可以从分支merge到主分支dev，注意：向主分支提交merge申请之前，需要先拉取最新代码，防止竞合。

	4.【强制】 代码merge完成之后，分支不再使用的，需要删除掉分支。

# 9.External dependencies
[External integrators relied on]

# 10.Environmental information
[Access methods for various environments, database connections, etc]

    local:
    dev:
    stage:
    prod:

# 11.Coding Practice
[Unified coding practices, such as exception handling principles, pagination encapsulation, etc]

### **一、命名规范**
1.【强制】代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。

2.【强制】代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式(即使纯拼音命名方式也要避免采用)。

3.【强制】类名使用UpperCamelCase风格。

4.【强制】方法名、参数名、成员变量、局部变量都统一使用lowerCamelCase风格，必须遵从驼峰形式。

5.【强制】常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
示例： MAX_STOCK_COUNT

6.【强制】类型与中括号紧挨相连来定义数组。

7.【参考】枚举类名建议带上Enum后缀，枚举成员名称需要全大写，单词间用下划线隔开。
// 枚举类型： ProcessStatusEnum
// 成员： SUCCESS / UNKNOWN_REASON

###**二、常量定义**
1.【强制】不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。

2.【强制】long或者Long初始赋值时，使用大写的L，不能是小写的l，小写容易跟数字1混淆，造成误解。

###**三、OOP规约**
1.【强制】避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可。

2.【强制】所有的覆写方法，必须加 @Override 注解。

3.【强制】相同参数类型，相同业务含义，才可以使用 Java 的可变参数，避免使用 Object。

4.【强制】外部正在调用或者二方库依赖的接口，不允许修改方法签名，避免对接口调用方产生影响。接口过时必须加 @Deprecated 注解，并清晰地说明采用的新接口或者新服务是什么。

5.【强制】不能使用过时的类或方法。

6.【强制】Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

7.【强制】所有整型包装类对象之间值的比较，全部使用 equals 方法比较。
说明: 对于 Integer var = ? 在-128 至 127 范围内的赋值，Integer 对象是在 IntegerCache.cache 产生，会复用已有对象，这个区间内的 Integer 值可以直接使用 == 进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用 equals 方法进行判断。

8.【强制】浮点数之间的等值判断，基本数据类型不能用 == 来比较，包装数据类型不能用 equals 来判断。

9.【强制】定义数据对象 DO 类时，属性类型要与数据库字段类型相匹配。

10.【强制】为了防止精度损失，禁止使用构造方法 BigDecimal(double) 的方式把 double 值转化为 BigDecimal 对象。

12.【强制】定义 DTO/VO/PO 等 POJO 类时，不要设定任何属性默认值。

说明:

PO(Persistent Object):持久对象，是一种OR映射关系，可以看成是与数据库中的表相映射的Java对象，也就是ORM框架中的entity实体类对象，PO类的每个属性基本上都对应数据库表里面的一个字段。

VO(View Object):视图对象，作用于页面展示层，主要对应的是指定页面层所展现的数据所封装的对象，作用是业务逻辑层与页面展示层进行传输交换数据。

DTO(Data Transfer Object):通常在页面展示层和业务层之间传递数据，DTO是PO通过一些业务逻辑处理后封装的对象，可能增加或减少PO的属性，属性的增加或减少是由数据传输对象与数据交互对象之间的差异决定的，简单的说就是接口之间传递数据封装，这样带来的好处就是一是方便数据交互，提高数据传输的速度，提高效率，二是能隐藏后端表结构。

DO（Domain Object）- 领域对象

13.【强制】序列化类新增属性时，请不要修改 serialVersionUID 字段，避免反序列失败;如果完全不兼容升级，避免反序列化混乱，那么请修改 serialVersionUID 值。

14.【强制】构造方法里面禁止加入任何业务逻辑，如果有初始化逻辑，请放在 init 方法中。

###**四、并发处理**

1.【强制】获取单例对象需要保证线程安全，其中的方法也要保证线程安全。

2.【强制】创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。

3.【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。

4.【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。

5.【强制】 SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为 static，必须加锁，或者使用 DateUtils 工具类。

6.【强制】必须回收自定义的 ThreadLocal 变量，尤其在线程池场景下，线程经常会被复用， 如果不清理自定义的 ThreadLocal 变量，可能会影响后续业务逻辑和造成内存泄露等问题。 尽量在代理中使用 try-finally 块进行回收。

7.【强制】高并发时，同步调用应该去考量锁的性能损耗。能用无锁数据结构，就不要用锁; 能锁区块，就不要锁整个方法体;能用对象锁，就不要用类锁。

8.【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造成死锁。

9.【强制】在使用阻塞等待获取锁的方式中，必须在try代码块之外，并且在加锁方法与try代码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。

10.【强制】在使用尝试机制来获取锁的方式中，进入业务代码块之前，必须先判断当前线程是否持有锁。锁的释放规则与锁的阻塞等待方式相同。

11.【强制】并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。

12.【强制】多线程并行处理定时任务时，Timer 运行多个 TimeTask 时，只要其中之一没有捕获抛出的异常，其它任务便会自动终止运行，如果在处理定时任务时使用 ScheduledExecutorService 则没有这个问题。

###**五、注释规约**

1.【强制】类、类属性、类方法的注释必须使用Javadoc规范，使用 /** 内容 */格式，不得使用 // xxx 方式。

2.【强制】所有的抽象方法(包括接口中的方法)必须要用 Javadoc 注释、除了返回值、参数、 异常说明外，还必须指出该方法做什么事情，实现什么功能。

3.【强制】所有的类都必须添加创建者和创建日期。

4.【强制】方法内部单行注释，在被注释语句上方另起一行，使用//注释。方法内部多行注释使用/* */注释，注意与代码对齐。

5.【强制】所有的枚举类型字段必须要有注释，说明每个数据项的用途。

```agsl
	Class:
	/**
     * @title: Demo Controller
     * @description: Demo
     * @author: Huang, Dylan Bo
     * @date: 2024-08-05
     */

	Method:
	/**
     * @title handle the logic
     * @param prefix prefix
     * @param suffix suffix
     * @author: Huang, Dylan Bo
     * @throws BusinessException BusinessException
     */
```

###**六、异常日志**
####（一）异常处理
1.【强制】Java 类库中定义的可以通过预检查方式规避的 RuntimeException 异常不应该通过 catch 的方式来处理，比如: NullPointerException，IndexOutOfBoundsException 等等。

2.【强制】异常不要用来做流程控制，条件控制。

3.【强制】catch时请分清稳定代码和非稳定代码，稳定代码指的是无论如何不会出错的代码。 对于非稳定代码的 catch 尽可能进行区分异常类型，再做对应的异常处理。

4.【强制】捕获异常是为了处理它，不要捕获了却什么都不处理而抛弃之，如果不想处理它， 请将该异常抛给它的调用者。最外层的业务使用者，必须处理异常，将其转化为用户可以理解的内容。

5.【强制】有 try 块放到了事务代码中，catch 异常后，如果需要回滚事务，一定要注意手动回滚事务。

6.【强制】finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。

7.【强制】不要在 finally 块中使用 return。

8.【强制】捕获异常与抛异常，必须是完全匹配，或者捕获异常是抛异常的父类。

9.【强制】在调用 RPC、二方包、或动态生成类的相关方法时，捕捉异常必须使用 Throwable 类来进行拦截。

####（二）日志规约

1.【强制】应用中不可直接使用日志系统(Log4j、Logback)中的 API，而应依赖使用日志框架 SLF4J 中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理方式统一。

2.【强制】所有日志文件至少保存15天，因为有些异常具备以“周”为频次发生的特点。网络运行状态、安全相关信息、系统监测、管理后台操作、用户敏感操作需要留存相关的网络日志不少于 6 个月。

3.【强制】应用中的扩展日志(如打点、临时监控、访问日志等)命名方式: appName_logType_logName.log。logType: 日志类型，如 stats/monitor/access 等;logName: 日志描述。这种命名的好处:通过文件名就可知道日志文件属于什么应用，什么类型，什么目的，也有利于归类查找。

4.【强制】在日志输出时，字符串变量之间的拼接使用占位符的方式。
正例: logger.debug("Processing trade with id: {} and symbol: {}", id, symbol);

5.【强制】对于 trace/debug/info 级别的日志输出，必须进行日志级别的开关判断。

6.【强制】避免重复打印日志，浪费磁盘空间，务必在 log4j.xml 中设置 additivity=false。
正例: <logger name="com.taobao.dubbo.config" additivity="false">

7.【强制】异常信息应该包括两类信息:案发现场信息和异常堆栈信息。如果不处理，那么通过关键字 throws 往上抛出。
正例: logger.error(各类参数或者对象 toString() + "_" + e.getMessage(), e);

###**七、安全规约**
1.【强制】隶属于用户个人的页面或者功能必须进行权限控制校验。
说明: 防止没有做水平权限校验就可随意访问、修改、删除别人的数据，比如查看他人的私信内容、修改他人的订单。

2.【强制】用户敏感数据禁止直接展示，必须对展示数据进行脱敏。
说明: 中国大陆个人手机号码显示为: 137****0969，隐藏中间 4 位，防止隐私泄露。

3.【强制】用户输入的 SQL 参数严格使用参数绑定或者 METADATA 字段值限定，防止 SQL 注入，禁止字符串拼接 SQL 访问数据库。

4.【强制】用户请求传入的任何参数必须做有效性验证。

5.【强制】禁止向 HTML 页面输出未经安全过滤或未正确转义的用户数据。

6.【强制】表单、AJAX 提交必须执行 CSRF 安全验证。

7.【强制】在使用平台资源，譬如短信、邮件、电话、下单、支付，必须实现正确的防重放的机制，如数量限制、疲劳度控制、验证码校验，避免被滥刷而导致资损。
说明: 如注册时发送验证码到手机，如果没有限制次数和频率，那么可以利用此功能骚扰到其它用户，并造成短信平台资源浪费。

###**八、事务规约**

1.【强制】数据变更类操作务必增加事务控制

2.【强制】事务注解增加 rollbackFor = Exception.class ，避免抛出受检异常，事务不回滚

3.【强制】避免大事务（如避免事务中处理过多数据、执行不必要的查询、执行耗时的操作），原则是能不放在事务中处理的操作就不放在事务中。

###**九、SQL规范**

1.【强制】禁止前%进行条件查询

2.【强制】禁止or查询，数据量多的情况下走不到索引

3.【强制】超过两张表以上SQL需要提交SQL审核，由DBA在生产环境执行explain给出合理优化建议。

4.【强制】新项目工程涉及到的SQL语句不能超过50ms。

###**十、代码提交**

Code submission format: 

	[Module_XXX] : Function

	[Module_XXX] :
		<br>
		1. Function0001<br>
		2. Function0002<br>
		3. Function0003<br>
		4. . . .

	For public functions, please use:
		[Common_XXX]: XXXXXXXXXXX

	e.g.
		[权限管理_用户] : 详细描述

        [通用管理_日期工具] : 详细描述

		[Common_Date]: Add the DateUtils class

# 12.References
Coming soon!

# 13.Q & A
Coming soon!

# 14.Swagger
LOCAL:http://localhost:8080/doc.html

VUE:

# 15.Code Generator
