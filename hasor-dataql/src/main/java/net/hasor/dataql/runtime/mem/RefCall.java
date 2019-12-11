/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.dataql.runtime.mem;
import net.hasor.dataql.Hints;
import net.hasor.dataql.UDF;
import net.hasor.dataql.runtime.InstructRuntimeException;
import net.hasor.utils.ExceptionUtils;

/**
 * 栈数据
 * @author 赵永春 (zyc@hasor.net)
 * @version : 2019-11-22
 */
public class RefCall {
    private UDF refCall;

    public RefCall(UDF refCall) {
        this.refCall = refCall;
    }

    public Object invokeMethod(Object[] paramArrays, Hints optionSet) throws InstructRuntimeException {
        try {
            return this.refCall.call(paramArrays, optionSet);
        } catch (Throwable e) {
            if (e instanceof InstructRuntimeException) {
                throw (InstructRuntimeException) e;
            }
            throw ExceptionUtils.toRuntimeException(e);
        }
    }
}