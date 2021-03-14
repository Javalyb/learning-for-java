Optional:
    在操作流对象时，可以防止因为null空对象而中断流;

空流:
    Stream.<String>empty();

创建Optional对象:
    1.Optional.empty(): 生成一个空Optional;
    2.Optional.of(T t): 将一个非控制包装在Optional中;
    3.Optional.ofNullable(T t): 针对一个可能为空的值，为空时自动生成Optional.empty，否则将值包装在Optional中;

通过流创建Optional对象:
    1.findFirst(): 返回一个包含第一个元素的Optional对象，如果流为空则返回Optional.empty;
    2.findAny(): 返回包含任意元素的Optional对象，如果流为空则返回Optional.empty;
    3.max()和min(): 返回一个包含最大值或者最小值的Optional对象，如果流为空则返回Optional.empty;

Optional方法:
    1.isPresent(): 检查是否有元素;
    2.get(): 获取元素;

Optional便利函数: 解包Optional，简化对所包含对象的检查和执行操作;
    1.ifPresent(Consumer): 当值存在时调用 Consumer，否则什么也不做;
    2.orElse(otherObject): 如果值存在则直接返回，否则生成 otherObject;
    3.orElseGet(Supplier): 如果值存在则直接返回，否则使用 Supplier 函数生成一个可替代对象;
    4.orElseThrow(Supplier): 如果值存在直接返回，否则使用 Supplier 函数生成一个异常;

Optional对象操作: 不适用于数值型Optional;
    1.filter(Predicate): 对Optional中的内容应用Predicate并将结果返回。
                         如果Optional不满足Predicate，将Optional转化为空Optional。
                         如果Optional已经为空，直接返回空Optional;
    2.map(Function): 如果Optional不为空，应用Function于Optional中的内容，并返回结果。否则返回Optional.empty;
    3.flatMap(Function): 同map，但是提供的映射函数将结果包装在Optional对象中，因此flatMap不会在最后进行任何包装;


    