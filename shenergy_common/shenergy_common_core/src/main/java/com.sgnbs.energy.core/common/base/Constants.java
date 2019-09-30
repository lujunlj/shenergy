package com.sgnbs.energy.core.common.base;



public interface Constants {

     String ERROR = "error";
     String USER_COOKIE = "user_token_v2";
     String USER_SESSION = "user";
     String BEFORE_URL = "before_url";
     String ADMIN_BEFORE_URL = "admin_before_url";
     String SESSION_ADMIN_USER = "admin_user";
     String TODAY = "today";
     String OP_ERROR_MESSAGE = "非法操作";
     String DELETE_FAILURE = "删除失败";

     String COOKIE_ADMIN_TOKEN = "admin_user_token";
    
    //逻辑删除标识符 0：正常   1：删除
     String DEL_FLAG_NORMAL = "0";
	 String DEL_FLAG_DELETE = "1";
	
	 String STATUS_NORMAL = "1";
	 String STATUS_DELETE = "99";


    interface ResultCode {
        Integer SUCCESS = 200;
        Integer again = 202;
        Integer FAILURE = 201;
        Integer ERROR = 500;
    }

    interface ResultDesc {
         String SUCCESS = "success";
         String FAILURE = "error";
    }

    interface RequestMethod {
         String GET = "get";
         String POST = "post";
    }

    Integer HTTP_RES_CODE_200 = 200;
    Integer HTTP_RES_CODE_500 = 500;
    Integer HTTP_RES_CODE_201 = 201;

    // 响应请求成功
    String HTTP_RES_CODE_200_VALUE = "success";
    // 系统错误
    String HTTP_RES_CODE_500_VALUE = "error";

}
