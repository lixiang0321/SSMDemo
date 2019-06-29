package www.ssm.util.sercurity;

import java.util.Base64;

/**
 * Base64加密工具类
 * @author 李枉然
 *
 */
public class BaseUtil {
	//定义加密次数
	private static final int COUNT =5;
	//定义盐值
	private static final String INFO = "mldn";
	private BaseUtil() {}
	/**
	 * 	加密方法取盐值，并加密5次
	 * @param str
	 * @return
	 */
	public static String encrypt(String str) {
		//定义加密规则
		String rule ="{"+INFO+"}" + str ;
		//加密准备
		Base64.Encoder encoder = Base64.getEncoder();
		//内部循环加密
		for (int i = 0; i < COUNT; i++) {
			rule = encoder.encodeToString(rule.getBytes());
		}
		return rule;
	}
	/**
	 * 解密算法
	 * @param str
	 * @return
	 */
	public static String decrypt(String str) {
		Base64.Decoder decoder = Base64.getDecoder();
		//获取解密字节数组
		byte[] bytes = str.getBytes();
		//内部循环加密
		for (int i = 0; i < COUNT; i++) {
			bytes = decoder.decode(bytes);
		}
		String pass = new String(bytes);
		return pass.substring(("{"+INFO+"}").length());
	}
}
