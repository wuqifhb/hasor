import 'net.hasor.dataql.fx.basic.JsonUdfSource' as json;

var insertMap = {
    "default"   : @@inner_dataway_sql(apiMethod, apiPath, apiStatus, apiComment, apiType, apiScript, apiSchema, apiSample)<%
        insert into interface_info (
            api_method,     api_path,   api_status, api_comment,
            api_type,       api_script, api_schema, api_sample,
            api_create_time,api_gmt_time
        ) values (
            :apiMethod,     :apiPath,   :apiStatus, :apiComment,
            :apiType,       :apiScript, :apiSchema, :apiSample,
            now(),          now()
        );
    %>
};

var res = insertMap[dbMapping](
    ${postData}.select,
    ${postData}.apiPath,
    0,
    ${postData}.comment,
    ${postData}.codeType,
    ${postData}.codeValue,
    "{}",
    json.toJson({
        "requestBody" : ${postData}.requestBody,
        "headerData"  : ${postData}.headerData => [ # ]
    })
);

var queryMap = {
    "default"   : @@inner_dataway_sql(apiMethod, apiPath)<% select api_id from interface_info where api_method= :apiMethod and api_path = :apiPath limit 1; %>
};

if (res == 1) {
    return queryMap[dbMapping](${postData}.select, ${postData}.apiPath);
} else {
    throw 500 ,"insert failed.";
}