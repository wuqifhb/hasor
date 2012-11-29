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
package org.more.hypha.xml.tags.beans.qpp;
import org.more.core.log.Log;
import org.more.core.log.LogFactory;
import org.more.hypha.AbstractPropertyDefine;
import org.more.hypha.ValueMetaData;
import org.more.hypha.define.Date_ValueMetaData;
import org.more.util.attribute.IAttribute;
/**
 * 将value的值转换为Date类型表述。<br/>
 * @version 2010-9-23
 * @author 赵永春 (zyc@byshell.org)
 */
public class QPP_Date implements QPP {
    private static Log log = LogFactory.getLog(QPP_Date.class);
    public ValueMetaData parser(IAttribute<String> attribute, AbstractPropertyDefine property) {
        String value = attribute.getAttribute("date");
        if (value == null)
            return null;
        //2.进行解析
        String format = attribute.getAttribute("format");
        Date_ValueMetaData newMETA = new Date_ValueMetaData();
        newMETA.setDateString(value);
        newMETA.setFormatString(format);
        log.debug("parser Date type value = {%0} , format = {%1}.", value, format);
        return newMETA;
    }
}