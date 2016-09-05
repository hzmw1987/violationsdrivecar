package com.test.violationsdrivecarCommon.util;


import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class SecurityUtils {

	/**
	 * 生成密码Hash
	 * 
	 * @param password
	 * @return 密码Hash
	 */
	public static String makePasswordHash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	/**
	 * 验证密码有效性
	 * 
	 * @param password
	 *            密码
	 * @param passwordHash
	 *            密码Hash
	 * @return 是否有效
	 */
	public static boolean verifyPassword(String password, String passwordHash) {
		return BCrypt.checkpw(password, passwordHash);
	}

	/**
	 * 产生一个新的Access-Token
	 * 
	 * @return
	 */
	public static String makeAccessToken() {
		return UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		String password = SecurityUtils.makePasswordHash("123321");
		System.out.println(password);
		/*if(SecurityUtils.verifyPassword("huanghengmeng", "$2a$10$AR3zy21EolYMUtiHYbIrkODLqi.hDQoL5WjowPKGoQomwFsERhFI6")){
			System.out.println("qwqwqwq");
		}*/
	}
}
