CREATE TABLE `srm_structure_calculate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `geometric` varchar(32) NOT NULL COMMENT '药型',
  `geometric_id` INTEGER NOT NULL COMMENT '药型ID',
  `time` datetime NOT NULL,
  `calculate_path` varchar(128) DEFAULT NULL COMMENT '计算路径',
  `material_id` INTEGER DEFAULT NULL COMMENT '材料ID',
  `ignition_id` INTEGER DEFAULT NULL COMMENT '点火参数ID',
  `cooling_id` INTEGER DEFAULT NULL COMMENT '降温参数ID',
  `eprincipal1` DOUBLE  COMMENT '降温结束最大应变',
  `eprincipal2` DOUBLE  COMMENT '点火结束最大应变',
  PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE srm_structure_material (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL COMMENT '用户名',
  poisson_ratio DOUBLE,
  expansion DOUBLE,
  density DOUBLE,
  modulus DOUBLE,
  prony_table VARCHAR(128),
  trs_table VARCHAR(128),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='材料参数表';

CREATE TABLE srm_structure_ignition(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL COMMENT '用户名',
  max_pressure DOUBLE,
  time_span DOUBLE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='点火参数表';

CREATE TABLE srm_structure_cooling(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL COMMENT '用户名',
  origin_temperature DOUBLE,
  final_temperature DOUBLE,
  time_span DOUBLE,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='降温参数表';

CREATE TABLE srm_structure_star(
  id bigint(20) NOT NULL AUTO_INCREMENT,
  user_name varchar(50) NOT NULL COMMENT '用户名',
  star_num INTEGER COMMENT '星角数',
  star_coefficient DOUBLE COMMENT '星角系数',
  outer_radius DOUBLE COMMENT '外径',
  feature_length DOUBLE COMMENT '特征长度',
  arc_radius DOUBLE COMMENT '过渡圆弧半径',
  start_angle DOUBLE COMMENT '星边夹角',
  star_arc_radius DOUBLE COMMENT '星角圆弧半径',
  ellipseyaxis DOUBLE COMMENT '封头高度',
  grain_length DOUBLE COMMENT '药柱长度',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='星形几何参数表';
