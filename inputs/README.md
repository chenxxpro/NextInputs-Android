
# NextInputs 的功能特性

* 轻量级，纯JDK实现，无任何第三方库依赖；
* 小巧，Jar文件仅30K+;
* 内置30+个常用校验模式;
* 支持自定义校验模式扩展;
* 支持自定义校验目标扩展;
* 支持自定义错误消息提示;

**NextInputs** 内建了两种校验模式分类：`静态校验模式`、`数值校验模式`。
使用NextInputs能够极大地提升开发效率，内置的多个校验模式已能应付开发常用的校验需求，如有特殊校验需求，通过扩展接口也能快速解决。

----

## 使用示例

```java
// 以下为演示对**固定值**进行判断的代码。
// 在Android中，对EditText的内容进行判断，需要使用Loader1A接口进行延迟加载。
// Android的数值加载方式，见另一项目：https://github.com/yoojia/NextInputs-Android
NextInputs inputs = new NextInputs();
inputs.add(InputProviders.fixedString("yoojia"))
        .with(StaticScheme.required())

        .add(InputProviders.fixedString("yoojia.chen@gmail.com"))
        .with(StaticScheme.email())

        .add(InputProviders.fixedString("13800138000"))
        .with(StaticScheme.chineseMobile())

        .add(InputProviders.fixedString("4121551474702170"))
        .with(StaticScheme.bankCard());

if(inputs.test()) {
    // Passed
}
```

----

## 配置 Gradle 依赖

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs:1.8'
}
```

----

# StaticScheme - 静态校验模式

**静态校验模式**也可以称为数据格式匹配模式。它的明显特征是在校验数据时时，不需要依赖基准参数来判断，而是直接对用户输入的数据检查其格式是否符合要求。如“邮件地址”、“电话号码”等数据格式的校验就属于此模式。


NextInputs目前内置包含以下静态校验模式，在未来版本也会加入其它使用频率较高的模式：

- Required - 必填模式
- NotBlank - 非空模式
- Digits - 数字模式
- Email - 邮件地址模式
- IPv4 - IP地址模式
- Host - 域名模式
- URL - URL地址模式
- Numeric - 数值模式
- BankCard - 银行卡/信用卡号码模式
- ChineseIDCard 身份证号码模式
- ChineseMobile 手机号码模式（国内）
- ChineseTelephone 固定电话号码模式（国内）
- MAC 设备物理地址（MAC Address）模式
- IsTrue - 结果为True模式
- IsFalse - 结果为False模式

#### Required - 必填模式

> 设置`Required`模式后，输入内容不能为空，这是NextInputs不允许空值的两条校验规则之一

在设置Required模式后，Required模式在校验时会优先于其它模式。其它校验模式在默认情况下将按代码添加顺序依次执行。

这里特别说明的是：

- Required的校验优先级默认为 `StaticScheme/ValueScheme.PRIORITY_REQUIRED(-1024)`，其它优先级为 `StaticScheme/ValueScheme.PRIORITY_GENERAL(0)`。
- **重要，重要，重要**：如果设置的校验条目中，你没有添加Required校验模式（或者NotBlank模式），在输入**内容为空**的情况下，校验结果是通过（Passed）的。

#### NotBlank - 非空数据模式

> 设置Required模式后，输入内容不能是任何空值，也是NextInputs不允许空值的两条校验规则之一

`StaticScheme.required()`，输入内容不能为任何空数据，除空数据外，还包括任意数量的纯空格、制表符等。

#### Digits - 数字模式

`StaticScheme.digits()`，输入内容只能是纯数字。

#### Email - 邮件地址模式

`StaticScheme.email()`，输入内容必须是有效的电子邮件地址。

#### IPv4 - IP地址模式

`StaticScheme.ipv4()`，输入内容必须是有效的IPv4地址。

#### Host - 主机地址模式

`StaticScheme.host()`，输入内容必须是有效的主机地址。这个模块包含了IPv4的校验。

#### URL - URL地址模式

`StaticScheme.url()`，输入内容必须是有效的URL地址。

#### Numeric - 数值模式

`StaticScheme.numeric()`，输入内容必须是有效的数值。

#### BankCard - 银行卡/信用卡号码模式

`StaticScheme.bankCard()`，输入内容必须是有效的银行卡号或者信用卡号。这个模式在实现上，使用银行卡号校验算法（Luhn）来校验，可以支持13位到19位长度的有效卡号。

#### ChineseIDCard 身份证号码模式

`StaticScheme.chineseIDCard()`，输入内容必须是有效的中国居民身份证号码。这个模式支持15位和18位身份证号的校验。

#### ChineseMobile 手机号码模式（国内手机号）

`StaticScheme.chineseMobile()`，输入内容必须是有效的手机号。这个手机号必须是11位国内手机号，其它国家或者地区的手机号暂不支持。

#### ChineseTelephone 固定电话号码模式（国内）

`StaticScheme.chineseMobile()`，输入内容必须是有效的固定电话号码。其它国家或者地区的手机号暂不支持。

#### MAC 设备物理地址（MAC Address）模式

`StaticScheme.MAC()`，输入内容必须是有效的设备物理地址。

#### IsTrue - 结果为True模式

`StaticScheme.isTrue()`，输入内容必须是True值。通常用于校验RadioBotton或者CheckBox等。

#### IsFalse - 结果为False模式

`StaticScheme.isFalse()`，输入内容必须是False值。通常用于校验RadioBotton或者CheckBox等。

----

# ValueScheme - 数值校验模式

**数值校验模式**需要指定校验参数来完成校验。在这种模式下，需要你提供一个基准值来做判断。例如“最小值”、“密码长度”等方式，就是使用这种模式。


NextInputs目前内置包含以下几种数值校验模式，在未来版本也会加入其它使用频率较高的模式：

- Required - 必填模式，与静态校验模式的必填模式相同。
- MinLength - 最小内容长度
- MaxLength - 最多内容长度
- RangeLength - 内容长度在指定范围内
- FixedLength - 内容长度在固定值
- MinValue - 最小值
- MaxValue - 最大值
- RangeValue - 数值范围
- Equals - 与指定内容相同
- NotEquals - 与指定内容不相同
- DateBefore - 在指定日期之前
- DateAfter - 在指定日期之后
- RangeDate - 在指定日期内
- DateTimeBefore - 在指定日期时间之前
- DateTimeAfter - 在指定日期时间之后
- RangeDateTime  - 在指定日期时间内
- TimeBefore - 在指定时间之前
- TimeAfter - 在指定时间之后
- RangeTime - 在指定时间内

### 特别说明：数值模式的延迟获取基准数值

在ValueScheme模式中，所有模式都需要一个基准数值来作为后续数值的判断标准。如“ValueScheme.MinLength”模式，如果直接指定**固定**数值：

> ValueScheme.minLength(10)

则表示立即设定最小长度模式的基准长度为10。在很多情况下，这个基准数值并非即时获取，需要从另一个对象中动态加载。这种情况下，需要使用延迟加载接口来实现：

```java
ValueScheme.minLength(new Loader1A<Long> {
  public Long getValue(){
    return Spinner.getValue();// 假定最小长度基准值由Spinner来设定。
  }
})
```

#### Required -  必填项目

`ValueScheme.required()`，与StaticScheme.Required相同。

#### MinLength - 最小内容长度

`ValueScheme.minLength(minLength)`，输入内容的长度至少（包括）为指定长度。

#### MaxLength - 最多内容长度

`ValueScheme.maxLength(maxLength)`，输入内容的长度最大（包括）为指定长度。

#### RangeLength - 内容长度在指定范围内

`ValueScheme.rangeLength(minLength, maxLength)`，输入内容的长度在指定范围内。

#### MinValue - 最小值

`ValueScheme.minValue(minValue)`，输入数值最小（包括）为指定数值。支持的数值类型：Int、Long、Float、Double；

#### MaxValue - 最大值

`ValueScheme.maxValue(minValue)`，输入数值最大（包括）为指定数值。支持的数值类型：Int、Long、Float、Double；

#### RangeValue - 数值范围

`ValueScheme.rangeValue(minValue, maxValue)`，输入数值在（包括）指定数值范围内。支持的数值类型：Int、Long、Float、Double；

#### Equals - 与指定内容相同

`ValueScheme.equals(...)`，输入内容与指定内容相同。Equals有两个实现方式，一个是`Equals(Loader<String>)`，另一个是`Equals(fixedString)`；

- `equals(Loader<String>)`，延迟加载参数形式。当开始校验时，Loader的`getValue`方法才会被执行，并要求返回一个用于匹配输入内容的字符串；
- `equals(fixedString)`，与指定固定字符串相同；

#### NotEquals - 与指定内容不相同

方式与`ValueScheme.Equals`相同，判断方式取反。

#### dateBefore - 在指定日期之前

校验输入的日期字符串要求符合`yyyy-MM-dd`格式，指定日期同上，也可以传入Date对象。

#### dateAfter - 在指定日期之后

校验输入的日期字符串要求符合`yyyy-MM-dd`格式，指定日期同上，也可以传入Date对象。

#### rangeDate - 在指定日期内

校验输入的日期字符串要求符合`yyyy-MM-dd`格式，指定日期同上，也可以传入Date对象。

#### rateTimeBefore - 在指定日期时间之前

校验输入的日期时间字符串要求符合`yyyy-MM-dd HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

#### dateTimeAfter - 在指定日期时间之后

校验输入的日期时间字符串要求符合`yyyy-MM-dd HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

#### rangeDateTime  - 在指定日期时间内

校验输入的日期时间字符串要求符合`yyyy-MM-dd HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

#### timeBefore - 在指定时间之前

校验输入的日期时间字符串要求符合`HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

#### timeAfter - 在指定时间之后

校验输入的日期时间字符串要求符合`HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

#### rangeTime - 在指定时间内

校验输入的日期时间字符串要求符合`HH:mm:ss`格式，指定日期时间同上，也可以传入Date对象。

----

# 设置校验失败提示消息

NextInputs内置的所有校验模式都自带提示消息，这些提示消息描述也比较“抽象”，很可能不符合你的业务需要。使用 `.msgOnFail(String)` 接口或者 `.msg(String)` 接口可以设置校验失败提示消息。当校验失败时，提示消息将通过MessageDisplay接口的具体实现类处理并显示出来。

这两个接口的作用是相同的，如果你觉得`.msg(String)`会导致你突然忘记这方法是干哈的，你可以使用`.msgOnFail(String)`方法来提醒自己。

使用 `NextInputs.setMessageDisplay(MessageDisplay)` 方法可以覆盖默认实现，使用你想要的校验失败提示方式。

----

# 自定义校验优先级

NextInputs是通过 `Scheme.priority` 的数值来决定优先级的，按数值升序。在非常有必要的情况下，可以使用 `Scheme.setPriority(int)` 方法来自定义校验模式的优先级。不建议自定义优先级，使用代码顺序即可。

----

# 空值

NextInputs对输入数据空值字符串的定义是：

```
input == null || input.length() == 0
```
----

# 版本更新

##### 1.8.2

- 电话号码校验模块，增加对工信部最近发放的199,166,198新号段支持；

##### 1.8

- 增加Date/Time/DateTime校验模式；
- ValueScheme的校验模式均增加Loader接口，以用于延迟获取校验基准数值。
- Scheme的提示消息接口：msg(String) / msgOnFail(String)，增加模板功能。使用{0}/{1}等可动态替换对应的基准数值。

##### 1.7

- 增加固定电话校验模式：ChineseTelephone
- 增加MAC物理地址校验模式：MAC

##### 1.6.2

- 更新手机号验证正则表达式；
- 增加FixedLength校验；
- 更新内部类名及包名；
- 增加clear()方法，用于移除全部校验条目；
- 修正BankCard拼写错误问题；

##### 1.5.3

- 使用 Provider 替代 Inputs 工具类

##### 1.5

- Schema 修正为 Scheme

##### 1.4.1

- 修正ValueScheme的RangeValue参数错误；

##### 1.4

- Pattern，StaticPattern，ValuePattern 标识为 @@Deprecated，并重命名为：Scheme, StaticScheme, ValueScheme

##### 1.3

- 增加流式API处理；

##### 1.1

- 更新各个校验模式的内部实现,分离其Tester；
- ValueScheme 修改为 ValueScheme
- ValueScheme.EqualsTo() 修改为 ValueScheme.Equals()；
- ValueScheme.NotEqualsTo() 修改为 ValueScheme.NotEquals()；
- ABTestBridge 更改为 ABBridge；
- AbstractTester 更改为 Verifier；
- Loader 更改为 LazyLoader；
- AllowEmptyTester 更改为 EmptyableVerifier；
- Loader 及 ABBridge 的onValue方法修改为 getValueX() 的形式；

----


# License

    Copyright 2015-2016 Yoojia Chen

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
