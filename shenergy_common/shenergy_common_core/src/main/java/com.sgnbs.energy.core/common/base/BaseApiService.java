package com.sgnbs.energy.core.common.base;

/**
 * 
 * 
 * @description: 微服务接口实现该接口可以使用传递参数可以直接封装统一返回结果集
 * @date: 2019年1月3日 下午3:03:17
 */
public class BaseApiService<T>  {

	public BaseResponse<T> error(Integer code, String msg) {
		return setResult(code, msg, null);
	}

	// 返回错误，可以传msg
	public BaseResponse<T> error(String msg) {
		return setResult(Constants.ResultCode.ERROR, msg, null);
	}

	// 返回成功，可以传data值
	public BaseResponse<T> success(T data) {
		return setResult(Constants.ResultCode.SUCCESS, Constants.ResultDesc.SUCCESS, data);
	}

	// 返回成功，沒有data值
	public BaseResponse<T> success() {
		return setResult(Constants.ResultCode.SUCCESS, Constants.ResultDesc.SUCCESS, null);
	}

	// 返回成功，沒有data值
	public BaseResponse<T> success(String msg) {
		return setResult(Constants.ResultCode.SUCCESS, msg);
	}

	// 通用封装
	public BaseResponse<T> setResult(Integer code, String msg, T data) {
		return new BaseResponse<T>(code, msg, data);
	}
	// 通用封装
	public BaseResponse<T> setResult(Integer code, String msg) {
		return new BaseResponse<T>(code, msg);
	}

	// 调用数据库层判断
	public Boolean toDaoResult(int result) {
		return result > 0 ? true : false;
	}

	// 接口直接返回true 或者false
	public Boolean isSuccess(BaseResponse<?> baseResp) {
		if (baseResp == null) {
			return false;
		}
		if (baseResp.getCode().equals(Constants.ResultCode.ERROR)) {
			return false;
		}
		return true;
	}

}
