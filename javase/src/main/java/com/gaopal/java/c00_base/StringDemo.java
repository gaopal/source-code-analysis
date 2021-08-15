package com.gaopal.java.c00_base;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public class StringDemo {

  @Test
  public void testFinal() {
    // value = {char[5]@966}[h, e, l, l, o]
    String string = "hello";
    // value = {char[5]@968}[w, o, r, l, d]
    string = "world";
    log.info(string);
  }

  @Test
  public void testGibberish() {
    String str1 = "nihao 你好 喬亂";

    // 设置使用ISO-8859-1编码读取字符串
    byte[] bytes = str1.getBytes(StandardCharsets.ISO_8859_1);
    String str2 = new String(bytes, StandardCharsets.ISO_8859_1);
    log.info(str2);

    // 设置使用UTF-8编码读取字符串
    bytes = str1.getBytes(StandardCharsets.UTF_8);
    String str3 = new String(bytes, StandardCharsets.UTF_8);
    log.info(str3);

    // Java默认使用UTF-8编码
    bytes = str1.getBytes();
    String str4 = new String(bytes);
    log.info(str4);
  }

  @Test
  public void testReplace() {
    String str = "hello world !!";
    log.info("替换之前: {}", str);
    str.replace('l', 'd');
    log.info("替换所有字符,但不接收返回值 :{}", str);
    str = str.replace('l', 'd');
    log.info("替换字符l为d: {}", str);
    str = str.replaceAll("d", "l");
    log.info("替换全部d为l: {}", str);
    str = str.replaceFirst("l", "");
    log.info("替换第一个l: {}", str);
  }

  @Test
  public void testSplit() {
    String s = "boo:and:foo:";
    log.info("s.split(\":\") 结果:{}", JSON.toJSONString(s.split(":")));
    log.info("s.split(\":\",2) 结果:{}", JSON.toJSONString(s.split(":", 2)));
    log.info("s.split(\":\",5) 结果:{}", JSON.toJSONString(s.split(":", 5)));
    log.info("s.split(\":\",-2) 结果:{}", JSON.toJSONString(s.split(":", -2)));
    log.info("s.split(\"o\") 结果:{}", JSON.toJSONString(s.split("o")));
    log.info("s.split(\"o\",2) 结果:{}", JSON.toJSONString(s.split("o", 2)));

    String a1 = ",a, ,  b  c ,null";
    log.info("a.split(\",\") 结果:{}", JSON.toJSONString(a1.split(",")));

    String a = ",a, ,  b  c ,";
    List<String> list =
        Splitter.on(',')
            // 去掉空格
            .trimResults()
            // 去掉空值
            .omitEmptyStrings()
            .splitToList(a);
    log.info("Guava 去掉空格的分割方法：{}", JSON.toJSONString(list));
  }

  @Test
  public void testJoin() {
    String s = "hello";
    String s1 = "china";
    s.replace("nihao", "sss");
    log.info(s.join(",", s1).join(",", "null"));

    // 通过Google提供的Guaua包依次 join 多个字符串
    Joiner joiner = Joiner.on(",").skipNulls();
    String result = joiner.join("hello", null, "china");
    log.info("依次 join 多个字符串:{}", result);

    List<String> list = Lists.newArrayList("hello", "china", null);
    log.info("自动删除 list 中空值:{}", joiner.join(list));

    String r1 = String.join(",", list);
    log.info("结果为:{}", r1);
  }

  @Test
  public void testLong128() {
    Long.valueOf(128);
    Long.valueOf(129);
  }

  @Test
  public void testReplaceAndAll() {
    StringBuffer strb = new StringBuffer();
    int size = 1000;
    for (int i = 0; i < size; i++) {
      strb.append("o");
    }
    String s = strb.toString();
    String s1 = strb.toString();
    long begin = System.currentTimeMillis();
    s.replace('o', 'l');
    log.info("循环{}次， replace 耗时{}", size, (System.currentTimeMillis() - begin));
    begin = System.currentTimeMillis();
    s1.replaceAll("o", "l");
    log.info("循环{}次， replace 耗时{}", size, (System.currentTimeMillis() - begin));
  }

  @Test
  public void testSplit2() {
    String s = "   i   ";
    char ch = '-';
    String[] sArrt = s.split("i", 1);
    System.out.println(sArrt);
  }

  @Test
  public void test() {
    "123123".substring(1, 3);
    String a = "123";
    String s = "123";
    System.out.println(a == s);
    System.out.println("123" == "123");
  }
}
