package com.test.violationsdrivecarCommon.util;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.test.violationsdrivecarCommon.exception.ApplicationException;
import com.test.violationsdrivecarCommon.model.ErrorStatus;



/**
 * 表单对象验证工具类, 用来对各个外部接口输入对象的有效性进行验证。
 * 
 *
 */
public class FormValidator {

	/**
	 * 验证输入对象的有效性，如果该对象无效将抛出应用程序异常。
	 * 
	 * @param o
	 *            待验证的对象
	 * @param groups
	 *            用来验证的约束组列表
	 * @throws ApplicationException
	 *             包含错误号、错误具体描述的应用程序异常对象
	 */
	public static <T> void validate(T o, Class<?>... groups) throws ApplicationException {
		List<ErrorStatus> errors = FormValidator.validateAll(o, groups);
		if (errors.size() > 0) {
			throw new ApplicationException(errors.get(0).getErrorCode() + "");
		}
	}

	/**
	 * 验证输入用户的有效性，并返回一个列表包含所有验证失败的约束项的错误状态。
	 * 
	 * @param o
	 *            待验证的对象
	 * @param groups
	 *            用来验证的约束组列表
	 * @return 包含所有验证失败约束项的错误状态（错误状态包含错误号和错误具体描述）列表，如果验证成功该列表将为空。
	 */
	public static <T> List<ErrorStatus> validateAll(T o, Class<?>... groups) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate(o, groups);
		List<ErrorStatus> results = new ArrayList<ErrorStatus>(violations.size());
		for (ConstraintViolation<T> violation : violations) {
			String propertyName = violation.getPropertyPath().toString();
			String propertyValue = "" + violation.getInvalidValue();
			ErrorStatus errorStatus = ErrorStatus.getErrorStatus(ErrorStatus.KEY_REQUECT_ERROR, propertyName,
					propertyValue);
			results.add(errorStatus);
		}
		return results;
	}
}
