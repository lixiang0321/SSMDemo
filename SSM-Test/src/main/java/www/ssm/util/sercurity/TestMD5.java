package www.ssm.util.sercurity;
/**
 *	使用Base64加密5此，并且使用MD5进行加密一次
 * 注意MD5加密不可逆。(无法解密)
 * @author WangRan
 *
 */
public class TestMD5 {
	public static String BaseMD5(String str) {
		String getMD5Code = EncryptUtil.GetMD5Code(BaseUtil.encrypt(str));
		return getMD5Code;
	}
	public static void main(String[] args) {
		//输入密码
		String a = "";
		System.out.println(TestMD5.BaseMD5(a));

	}
}
