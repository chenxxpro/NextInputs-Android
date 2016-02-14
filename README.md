
**NextInputs-Android** 基于 NextInputs [https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs) 的扩展，增加Android组件的支持。

NextInputs项目地址：[https://github.com/yoojia/NextInputs](https://github.com/yoojia/NextInputs)

# 特性

- 轻量级，自然快;
- 使用简单;
- 内置大量常用校验模式;
- 支持自定义校验模式扩展;
- 支持自定义校验目标扩展;
- 支持自定义错误消息提示;

# 使用示例

```java
AndroidNextInputs inputs = new AndroidNextInputs();
inputs.add(Inputs.editText(mUsernameEditText),
        StaticPattern.Required(),
        StaticPattern.Email()
);
boolean passed = inputs.test();
```

# 配置 Gradle 依赖

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:<latest-version>'
}
```

当前最新版本为 `1.0-beta`：

```groovy
dependencies {
    compile 'com.github.yoojia:next-inputs-android:1.0-beta'
}
```
