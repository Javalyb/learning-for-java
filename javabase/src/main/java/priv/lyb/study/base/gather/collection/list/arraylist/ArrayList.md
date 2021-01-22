ArrayList:
    有序的集合列表，按插入顺序输出;

ListIterator:
    只能由List子类创建;
    1.可以双向移动;
    2.可以获取集合指定位置的迭代器;

List泛型菱形语法:
    new ArrayList<>()，jdk7前需要在两端都进行类型声明，在这之后不需要强迫右侧再重复声明类型;