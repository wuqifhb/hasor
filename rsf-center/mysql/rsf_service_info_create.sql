create table `RSF_ServiceInfo` (
	`si_serviceID`		BIGINT			NOT NULL AUTO_INCREMENT COMMENT '服务编号（PK、自增）',
	`si_appID`			BIGINT			NOT NULL 				COMMENT '所属应用ID',
	`si_bindID`			VARCHAR(300)	NOT NULL 				COMMENT '服务ID',
	`si_bindName`		VARCHAR(200)	NOT NULL 				COMMENT '服务名',
	`si_bindGroup`		VARCHAR(100)	NOT NULL 				COMMENT '所属分组',
	`si_bindVersion`	VARCHAR(50)		NOT NULL 				COMMENT '接口版本',
	`si_bindType`		VARCHAR(300)	NOT NULL 				COMMENT '接口类型',
	`si_onwer`			VARCHAR(50)		NULL DEFAULT NULL		COMMENT '应用Owner（应用创建人）',
	`si_contactUsers`	VARCHAR(200)	NULL DEFAULT NULL		COMMENT '应用联络人（可以是多人）',
	`si_hashCode`		VARCHAR(36)		NOT NULL 				COMMENT '服务HashCode',
	`si_create_time`	DATETIME		NULL					COMMENT '创建时间',
	`si_modify_time`	DATETIME		NULL					COMMENT '修改时间',
	PRIMARY KEY (`si_serviceID`),
	UNIQUE KEY `UK_RSF_SERVICE_INFO_CODE` (`si_appID`,`si_bindID`),
	UNIQUE KEY `UK_RSF_APP_APP_CODE` (`si_bindName`,`si_bindGroup`,`si_bindVersion`),
	UNIQUE KEY `UK_RSF_SERVICE_INFO_CODE` (`si_hashCode`),
);