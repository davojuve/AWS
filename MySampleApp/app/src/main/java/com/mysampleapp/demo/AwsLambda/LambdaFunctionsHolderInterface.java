package com.mysampleapp.demo.AwsLambda;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunction;

/*
 * A holder for lambda functions
 */
public interface LambdaFunctionsHolderInterface {
//    /**
//     * Invoke lambda function "echo". The function name is the method name
//     */
//    @LambdaFunction
//    String mEcho(NameInfo nameInfo);
//
//    /**
//     * Invoke lambda function "echo". The functionName in the annotation
//     * overrides the default which is the method name
//     */
//    @LambdaFunction(functionName = "mEcho")
//    void noEcho(NameInfo nameInfo);

    /**
     * Invoke lambda function "echo". The function name is the method name
     * @param userInfo
     */
    @LambdaFunction
    String addItemToUsers(UserInfo userInfo);
}
