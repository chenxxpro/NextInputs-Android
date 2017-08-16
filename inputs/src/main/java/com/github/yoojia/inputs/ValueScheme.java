package com.github.yoojia.inputs;

import com.github.yoojia.inputs.verifiers.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.4
 */
public class ValueScheme {

    public static final int PRIORITY_REQUIRED = StaticScheme.PRIORITY_REQUIRED;
    public static final int PRIORITY_GENERAL = StaticScheme.PRIORITY_GENERAL;

    /**
     * 必要项，输入内容不能为空
     * @return Scheme
     */
    public static Scheme Required(){
        return StaticScheme.Required();
    }

    /**
     * 输入内容不能小于最小长度
     * @param fixedLength 最小长度
     * @return Scheme
     */
    public static Scheme MinLength(final long fixedLength) {
        return new Scheme(new MinLengthVerifier(fixedLength)).msg("输入内容至少{0}个字符");
    }

    /**
     * 输入内容不能小于最小长度
     * @param lengthLoader 最小长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme MinLength(Loader1A<Long> lengthLoader) {
        return new Scheme(new MinLengthVerifier(lengthLoader)).msg("输入内容至少{0}个字符");
    }

    /**
     * 输入内容不能大于最大长度
     * @param fixedLength 最大长度数值延迟加载器
     * @return Scheme
     */
    public static Scheme MaxLength(final long fixedLength) {
        return new Scheme(new MaxLengthVerifier(fixedLength)).msg("输入内容最多{0}个字符");
    }

    /**
     * 输入内容不能大于最大长度
     * @param lengthLoader 最大长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme MaxLength(final Loader1A<Long> lengthLoader) {
        return new Scheme(new MaxLengthVerifier(lengthLoader)).msg("输入内容最多{0}个字符");
    }

    /**
     * 输入内容在长度范围内
     * @param fixedMinValueLength 最小长度
     * @param fixedMaxValueLength 最大长度
     * @return Scheme
     */
    public static Scheme RangeLength(final long fixedMinValueLength, final long fixedMaxValueLength) {
        return new Scheme(new RangeLengthVerifier(fixedMinValueLength, fixedMaxValueLength)).msg("输入内容字符数量必须在[{0},{1}]之间");
    }

    /**
     * 输入内容在长度范围内
     * @param lengthLoader 最小、最大长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme RangeLength(Loader2A<Long> lengthLoader) {
        return new Scheme(new RangeLengthVerifier(lengthLoader)).msg("输入内容字符数量必须在[{0},{1}]之间");
    }

    /**
     * 限制内容为固定长度
     * @param fixedLength 固定长度
     * @return Scheme
     */
    public static Scheme FixedLength(final long fixedLength) {
        return new Scheme(new FixedLengthVerifier(fixedLength)).msg("输入内容固定长度为{0}");
    }

    /**
     * 限制内容为固定长度
     * @param lengthLoader 固定长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme FixedLength(final Loader1A<Long> lengthLoader) {
        return new Scheme(new FixedLengthVerifier(lengthLoader)).msg("输入内容固定长度为{0}");
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMinValue 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final Integer fixedMinValue) {
        return MinValue(fixedMinValue.doubleValue());
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMinValue 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final Long fixedMinValue) {
        return MinValue(fixedMinValue.doubleValue());
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMinValue 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final Float fixedMinValue) {
        return MinValue(fixedMinValue.doubleValue());
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMinValue 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final Double fixedMinValue) {
        return new Scheme(new MinValueVerifier(fixedMinValue)).msg("输入数值最小为{0}");
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final Integer fixedMaxValue) {
        return MaxValue(fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final Long fixedMaxValue) {
        return MaxValue(fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final Float fixedMaxValue) {
        return MaxValue(fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final Double fixedMaxValue) {
        return new Scheme(new MaxValueVerifier(fixedMaxValue)).msg("输入数值最大为{0}");
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMinValue 最小值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final Integer fixedMinValue, final Integer fixedMaxValue) {
        return RangeValue(fixedMinValue.doubleValue(), fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMinValue 最小值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final Long fixedMinValue, final Long fixedMaxValue) {
        return RangeValue(fixedMinValue.doubleValue(), fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMinValue 最小值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final Float fixedMinValue, final Float fixedMaxValue) {
        return RangeValue(fixedMinValue.doubleValue(), fixedMaxValue.doubleValue());
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMinValue 最小值
     * @param fixedMaxValue 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final Double fixedMinValue, final Double fixedMaxValue) {
        return new Scheme(new RangeValueVerifier(fixedMinValue, fixedMaxValue)).msg("输入数值大小必须在[{0},{1}]之间");
    }

    /**
     * 输入内容与加载器的内容相同
     * @param lazyLoader 相同内容延迟加载器
     * @return Scheme
     */
    public static Scheme EqualsTo(final Loader1A<String> lazyLoader){
        return new Scheme(new EqualsVerifier(lazyLoader)).msg("输入内容与要求不一致");
    }

    /**
     * 输入内容必须与指定内容相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme EqualsTo(final String fixedValue) {
        return new Scheme(new EqualsVerifier(fixedValue)).msg("输入内容与要求不一致");
    }

    /**
     * 输入内容必须与加载器的内容不相同
     * @param lazyLoader 加载器
     * @return Scheme
     */
    public static Scheme NotEquals(final Loader1A<String> lazyLoader){
        return new Scheme(new NotEqualsVerifier(lazyLoader)).msg("输入内容不能与要求的相同");
    }

    /**
     * 输入内容必须与指定内容不相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme NotEquals(final String fixedValue) {
        return new Scheme(new NotEqualsVerifier(fixedValue)).msg("输入内容不能与要求的相同");
    }
    
    // date

    private static final String DATE_MSG_AFTER = "设定的日期必须在{0}之后";
    private static final String DATE_MSG_BEFORE = "设定的日期必须在{0}之前";

    public static Scheme DateAfter(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDate, format)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final String basedDate){
        return new Scheme(new DateAfterVerifier(basedDate)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDateLoader, format)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Loader1B<String> basedDateLoader){
        return new Scheme(new DateAfterVerifier(basedDateLoader)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDate, format)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Loader1A<Date> basedDateLoader){
        return new Scheme(new DateAfterVerifier(basedDateLoader)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDateLoader, format)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateAfter(final Date basedDate){
        return new Scheme(new DateAfterVerifier(basedDate)).msg(DATE_MSG_AFTER);
    }

    public static Scheme DateBefore(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDate, format)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final String basedDate){
        return new Scheme(new DateBeforeVerifier(basedDate)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDateLoader, format)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Loader1B<String> basedDateLoader){
        return new Scheme(new DateBeforeVerifier(basedDateLoader)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDate, format)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Date basedDate){
        return new Scheme(new DateBeforeVerifier(basedDate)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDateLoader, format)).msg(DATE_MSG_BEFORE);
    }

    public static Scheme DateBefore(final Loader1A<Date> basedDateLoader){
        return new Scheme(new DateBeforeVerifier(basedDateLoader)).msg(DATE_MSG_BEFORE);
    }
    
    // range date

    private static final String DATE_MSG_RANGE = "设定的日期必须在{0} - {1}之间";

    public static Scheme RangeDate(final String minDate, final String maxDate, final SimpleDateFormat format){
        return new Scheme(new RangeDateVerifier(minDate, maxDate, format)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final String minDate, final String maxDate){
        return new Scheme(new RangeDateVerifier(minDate, maxDate)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Loader2B<String> minDateLoader, final SimpleDateFormat format){
        return new Scheme(new RangeDateVerifier(minDateLoader, format)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Loader2B<String> minDateLoader){
        return new Scheme(new RangeDateVerifier(minDateLoader)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Date minDate, final Date maxDate, final SimpleDateFormat format){
        return new Scheme(new RangeDateVerifier(minDate, maxDate, format)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Date minDate, final Date maxDate){
        return new Scheme(new RangeDateVerifier(minDate, maxDate)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Loader2A<Date> rangeDateLoader, final SimpleDateFormat format){
        return new Scheme(new RangeDateVerifier(rangeDateLoader, format)).msg(DATE_MSG_RANGE);
    }

    public static Scheme RangeDate(final Loader2A<Date> rangeDateLoader){
        return new Scheme(new RangeDateVerifier(rangeDateLoader)).msg(DATE_MSG_RANGE);
    }
    
    // time

    private static final String TIME_MSG_AFTER = "设定的时间必须在{0}之后";
    private static final String TIME_MSG_BEFORE = "设定的时间必须在{0}之前";

    public static Scheme TimeAfter(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedDate, format)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final String basedDate){
        return new Scheme(new TimeAfterVerifier(basedDate)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedDateLoader, format)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Loader1B<String> basedDateLoader){
        return new Scheme(new TimeAfterVerifier(basedDateLoader)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedDate, format)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Loader1A<Date> basedDateLoader){
        return new Scheme(new TimeAfterVerifier(basedDateLoader)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedDateLoader, format)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeAfter(final Date basedDate){
        return new Scheme(new TimeAfterVerifier(basedDate)).msg(TIME_MSG_AFTER);
    }

    public static Scheme TimeBefore(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new TimeBeforeVerifier(basedDate, format)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final String basedDate){
        return new Scheme(new TimeBeforeVerifier(basedDate)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new TimeBeforeVerifier(basedDateLoader, format)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Loader1B<String> basedDateLoader){
        return new Scheme(new TimeBeforeVerifier(basedDateLoader)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new TimeBeforeVerifier(basedDate, format)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Date basedDate){
        return new Scheme(new TimeBeforeVerifier(basedDate)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new TimeBeforeVerifier(basedDateLoader, format)).msg(TIME_MSG_BEFORE);
    }

    public static Scheme TimeBefore(final Loader1A<Date> basedDateLoader){
        return new Scheme(new TimeBeforeVerifier(basedDateLoader)).msg(TIME_MSG_BEFORE);
    }

    // range time

    private static final String TIME_MSG_RANGE = "设定的时间必须在{0} - {1}之间";

    public static Scheme RangeTime(final String minTime, final String maxTime, final SimpleDateFormat format){
        return new Scheme(new RangeTimeVerifier(minTime, maxTime, format)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final String minTime, final String maxTime){
        return new Scheme(new RangeTimeVerifier(minTime, maxTime)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Loader2B<String> rangeTimeLoader, final SimpleDateFormat format){
        return new Scheme(new RangeTimeVerifier(rangeTimeLoader, format)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Loader2B<String> rangeTimeLoader){
        return new Scheme(new RangeTimeVerifier(rangeTimeLoader)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Date minTime, final Date maxTime, final SimpleDateFormat format){
        return new Scheme(new RangeTimeVerifier(minTime, maxTime, format)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Date minTime, final Date maxTime){
        return new Scheme(new RangeTimeVerifier(minTime, maxTime)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Loader2A<Date> rangeTimeLoader, final SimpleDateFormat format){
        return new Scheme(new RangeTimeVerifier(rangeTimeLoader, format)).msg(TIME_MSG_RANGE);
    }

    public static Scheme RangeTime(final Loader2A<Date> rangeTimeLoader){
        return new Scheme(new RangeTimeVerifier(rangeTimeLoader)).msg(TIME_MSG_RANGE);
    }

    // date time
    
    private static final String DATE_TIME_MSG_AFTER = "设定的日期时间必须在{0}之后";
    private static final String DATE_TIME_MSG_BEFORE = "设定的日期时间必须在{0}之前";

    public static Scheme DateTimeAfter(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDate, format)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final String basedDate){
        return new Scheme(new DateTimeAfterVerifier(basedDate)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDateLoader, format)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Loader1B<String> basedDateLoader){
        return new Scheme(new DateTimeAfterVerifier(basedDateLoader)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDate, format)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Loader1A<Date> basedDateLoader){
        return new Scheme(new DateTimeAfterVerifier(basedDateLoader)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDateLoader, format)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeAfter(final Date basedDate){
        return new Scheme(new DateTimeAfterVerifier(basedDate)).msg(DATE_TIME_MSG_AFTER);
    }

    public static Scheme DateTimeBefore(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateTimeBeforeVerifier(basedDate, format)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final String basedDate){
        return new Scheme(new DateTimeBeforeVerifier(basedDate)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Loader1B<String> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateTimeBeforeVerifier(basedDateLoader, format)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Loader1B<String> basedDateLoader){
        return new Scheme(new DateTimeBeforeVerifier(basedDateLoader)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateTimeBeforeVerifier(basedDate, format)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Date basedDate){
        return new Scheme(new DateTimeBeforeVerifier(basedDate)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Loader1A<Date> basedDateLoader, final SimpleDateFormat format){
        return new Scheme(new DateTimeBeforeVerifier(basedDateLoader, format)).msg(DATE_TIME_MSG_BEFORE);
    }

    public static Scheme DateTimeBefore(final Loader1A<Date> basedDateLoader){
        return new Scheme(new DateTimeBeforeVerifier(basedDateLoader)).msg(DATE_TIME_MSG_BEFORE);
    }

    // range date time

    private static final String DATE_TIME_MSG_RANGE = "设定的日期时间必须在{0} - {1}之间";

    public static Scheme RangeDateTime(final String minDateTime, final String maxDateTime, final SimpleDateFormat format){
        return new Scheme(new RangeDateTimeVerifier(minDateTime, maxDateTime, format)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final String minDateTime, final String maxDateTime){
        return new Scheme(new RangeDateTimeVerifier(minDateTime, maxDateTime)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Loader2B<String> dateTimeLoader, final SimpleDateFormat format){
        return new Scheme(new RangeDateTimeVerifier(dateTimeLoader, format)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Loader2B<String> dateTimeLoader){
        return new Scheme(new RangeDateTimeVerifier(dateTimeLoader)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Date minDateTime, final Date maxDateTime, final SimpleDateFormat format){
        return new Scheme(new RangeDateTimeVerifier(minDateTime, maxDateTime, format)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Date minDateTime, final Date maxDateTime){
        return new Scheme(new RangeDateTimeVerifier(minDateTime, maxDateTime)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Loader2A<Date> rangeDateTimeLoader, final SimpleDateFormat format){
        return new Scheme(new RangeDateTimeVerifier(rangeDateTimeLoader, format)).msg(DATE_TIME_MSG_RANGE);
    }

    public static Scheme RangeDateTime(final Loader2A<Date> rangeDateTimeLoader){
        return new Scheme(new RangeDateTimeVerifier(rangeDateTimeLoader)).msg(DATE_TIME_MSG_RANGE);
    }
}
