
**NextInputs-Android** 基于 NextInputs [https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs) 的扩展，
增加对Android组件的支持。

# NextInput功能特性及介绍

在NextInputs项目有非常详细的介绍。详见NextInputs项目，地址：[https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs)

更多相关说明，见博客：[http://blog.csdn.net/yoojia/article/details/50821055](http://blog.csdn.net/yoojia/article/details/50821055)

----

# 使用示例

```java
final AndroidNextInputs inputs = new AndroidNextInputs();
final InputsAccess access = new InputsAccess(this);
// 一、流式API
inputs  // 必选，手机号
        .on(access.findEditText(R.id.form_field_1))
        .with(StaticPattern.Required(), StaticPattern.ChineseMobile())
        // 信用卡
        .on(access.findEditText(R.id.form_field_2))
        .with(StaticPattern.BlankCard());
// 二、标准API
// 必选，数字，最大20字符
inputs.add(access.findEditText(R.id.form_field_3), StaticPattern.Required(), StaticPattern.Digits(), ValuePattern.MaxLength(20));
// 必选，邮件
inputs.add(access.findEditText(R.id.form_field_4), StaticPattern.Required(), StaticPattern.Email());
// 必选，与邮件相同
final LazyLoaders loader = new LazyLoaders(this);
        inputs.add(access.findEditText(R.id.form_field_5), ValuePattern.Required(), ValuePattern.EqualsTo(loader.fromEditText(R.id.form_field_4)));
// 执行校验，并返回校验结果
boolean passed = inputs.test();

```

# Android扩展

### AndroidMessageDisplay

`AndroidNextInputs` 增加了Android支持，默认使用的AndroidMessageDisplay实现了Android内置组件的错误展示功能 ：使用TextView.setError()和Toast来展示校验失败的消息。

### InputsAccess

`InputsAccess` 是一个为Android创建的扩展工具类，用于读取输入组件的数据，通过它可以快捷地读取布局文件中的EditText等组件及其数据。

- findXXX 等方法可用于快速查找各类型的View；
- getXXX 等方法可快速读取各类型View的数值；

### LazyLoaders

`LazyLoaders` 是一个为Android创建的扩展工具类，用于延迟加载组件数据，通过它可以快捷地添加基于Android输入组件的延迟加载器。

----

# 配置 Gradle 依赖

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:<latest-version>'
}
```

当前最新版本为 `1.2.2`：

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:1.2.2'
}
```
----

# Change Log

### 1.2.1

- NextInputs 更新为 1.3 版本，移除Fluent，使用NextInputs的Fluent来实现流式API；
- LazyLoaders 增加 fromEditText(EditText) 和 fromTextView(TextView) 方法；

### 1.2

- AndroidNextInputs增加流式API支持，可用 on(...).with(...) 链式调用来设置校验目标和规则；
- InputsFinder 更新为 InputsAccess ；
- InputsAccess 增加 getInt / getLong / getFloat / getDouble等方法；

### 1.1

- TextLoader 修改为 TextLazyLoader
- FormInput 更改为 InputsFinder
- FormLoader 更改为 LazyLoaders

----

# License

    Copyright 2015 Yoojia Chen

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

