package com.inspur.test;

import java.net.URLEncoder;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @author 高大鹏
 * @version 1.0 功能 ：釆用3DES标准以模式为ECB、填充方式为PKCS5加密数据 
 */
public class TripleDES {
	
    private Cipher cipher = null;
    // 密钥 
    private String key = "";
    // 过滤换行  
    private boolean filter = true;
  
    public String getKey(){
        return key;
    }
  
    public boolean getFilter(){  
        return filter;
    }
     
    /**
     * 设置密钥
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    public void setFilter(boolean filter) {  
        this.filter = filter;
    }

    private final Cipher initCipher(int mode){
        try {
			// 添加新安全算法:PKCS7
			Security.addProvider(new BouncyCastleProvider());
			String algorithm = "DESede/ECB/PKCS5Padding";
			//          SecretKey desKey = new SecretKeySpec((new BASE64Decoder()).decodeBuffer(key), algorithm);
			SecretKey desKey = new SecretKeySpec(key.getBytes("ASCII"), algorithm);
			Cipher tcipher = Cipher.getInstance(algorithm);
			tcipher.init(mode, desKey);
			return tcipher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密以charset编码做为密文
     *
     * @param src
     *            明文
     * @param charset
     *            编码,例：UTF8
     * @return
     */
    public String encrypt(String src, String charset) {
        try{
            return URLEncoder.encode(encrypt(src), charset);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param src 二进制数组
     * @return
     * @throws Exception
     */
    private byte[] decrypt(byte[] src) throws Exception {
        cipher = initCipher(Cipher.DECRYPT_MODE);
        return cipher.doFinal(src);
    }
    
    /**
     * 解密
     * @param src 密文
     * @return
     * @throws Exception
     */
    public  String decrypt(String src) throws Exception {
//    	src = toStringHex(src);
//    	System.out.println("src:"+src);
//    	System.out.println("base:"+base64Decode.decodeBuffer(src));
//      byte[] bt=base64Decode.decodeBuffer(src);
//    	byte[] bt= src.getBytes();
    	byte[] bt= HexString2Bytes(src);
        byte[] sbt=decrypt(bt);
        return new String(sbt,"ASCII");
    }
    
    /**
     * 加密以base64做为密文
     *
     * @param src
     *            明文
     * @return 密文
     */
    public String encrypt(String src) {
        cipher = initCipher(Cipher.ENCRYPT_MODE);
        byte[] dd = encrypt(src.getBytes());
        String str = "";
//      str = base64Encode.encode(dd);
        str = Bytes2HexString(dd);
        return str;
    }
	  
    /**
     *
     * @param src
     * @return
     */
	public byte[] encrypt(byte[] src) {
		try {
			return cipher.doFinal(src);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    private final static byte[] hex = "0123456789ABCDEF".getBytes();

    private static int parse(char c) {
        if (c >= 'a')
            return (c - 'a' + 10) & 0x0f;
        if (c >= 'A')
            return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }
    // 从字节数组到十六进制字符串转换
    public static String Bytes2HexString(byte[] b) {
        byte[] buff = new byte[2 * b.length];
        for (int i = 0; i < b.length; i++) {
            buff[2 * i] = hex[(b[i] >> 4) & 0x0f];
            buff[2 * i + 1] = hex[b[i] & 0x0f];
        }
        return new String(buff);
    }
    
    // 从十六进制字符串到字节数组转换
    public static byte[] HexString2Bytes(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
    	TripleDES cWebService3DES = new TripleDES();
    	Security.addProvider(new com.sun.crypto.provider.SunJCE());
        cWebService3DES.key = "201710010000000000000000".toUpperCase();
       // System.out.println(cWebService3DES.decrypt("52BDFAE86141712E80EE6B5F9082275FBD5359045893CE4D907643B49690DCDDF11CC7497BFDFD4577835CFADB33C7BF13573035DF7E7B98A31C8079E5D6420D3BFE69D66F383C7A516203682F5149A0C9FBAB03D740E2072AFCBDF4C92DC16E17CDD842C6C8CFCE1C4BF88DF922F6F6814D388A9DFD3F0C10B6A8C99D94FCCE"));
        //38658042 $ 6956V2EB84LC2NH0FM7101CVOGTF3O65 $ 02423267529 $ 0010019900603081G125308HCC743259 $ 192.168.0.103 $ 00:07:67:fc:da:5b $ $ CTC
        //System.out.println(cWebService3DES.encrypt("38658042$YT8mYLPUCRKStuPvZNc1502179049261$32423267529$0010019900603081G125308HCC743259$192.168.0.103$00:07:67:fc:da:5b$$CTC"));
//        System.out.println(cWebService3DES.encrypt("38658042$6hOgyQ07JcdBmMjG8tO1505116148632$jntest34$0010019900603081G125308HCC743259$192.168.0.103$ac:56:ba:b9:47:c8$$CTC"));
        //38658042$PKYtwAapXA5AoBVTojE1501122421525$shenmltest$0010019900603081G125308HCC743259$192.168.0.103$44:07:63:db:e0:a1$$CTC
        //System.out.println(cWebService3DES.decrypt("52BDFAE86141712EAA4EFD58FD385DFC91C2AE8D315EC6EEC43C5D31DED2155804D25E2FA1CE05F8590A8BBA9A84A5EA22FEFB8B61539650B2F029113272DA098C516840D8FEBDB128BA64973B8E625A39B88376B9CC48B3751DFE9B5A7D6FEF2B8996CAB66346385B06B1F0000965FCE57F865E7899DA9345FB51D63D065030"));
        /**
         * 1.Random		取值(现在采用定值就OK):38658042
         * 2.temptoken	取值方式:通过Authentication接口获取
         * 3.userId		用户的userId
         * 4.终端编号:		采取固定值:0010019900603081G125308HCC743259
         * 5.IP地址:		采用固定值(可以随机):192.168.1.109
         * 6.Mac:		用户对应的Mac
         * 7.空值(什么都不填)
         * 8.CTC
         */
        System.out.println(cWebService3DES.encrypt("38658042$8qdyaDTSNC27IKb2Pxh1524536638744$T0057$0010019900603081G125308HCC743259$192.168.1.109$ac:4a:fe:9d:fb:9b$$CTC"));
    }
}