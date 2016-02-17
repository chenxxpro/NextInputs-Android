
**NextInputs-Android** 基于 NextInputs [https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs) 的扩展，
增加对Android组件的支持。

# NextInput功能特性及介绍

在NextInputs项目有非常详细的介绍。详见NextInputs项目，地址：[https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs)

----

# 使用示例

```java
AndroidNextInputs inputs = new AndroidNextInputs();
InputsFinder formFinder = new InputsFinder(this);
inputs.add(formFinder.findEditText(R.id.form_field_1), StaticPattern.Required(), StaticPattern.ChineseMobile());
boolean passed = inputs.test();
```

# Android扩展

`AndroidNextInputs` 增加了Android支持，使用Android内置的TextView.setError()和Toast来展示校验失败的消息。
`InputsFinder` 是一个为Android创建的扩展工具类，用于读取输入组件的数据。通过它可以快捷地读取布局文件中的EditText等组件。
`LazyLoaders` 是一个为Android创建的扩展工具类，用于延迟。通过它可以快捷地添加基于Android输入组件的延迟加载器。

----

# 配置 Gradle 依赖

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:<latest-version>'
}
```

当前最新版本为 `1.1-beta`：

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:1.1-beta'
}
```
----

# Change Log

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

