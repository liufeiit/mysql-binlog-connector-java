# Changelog
All notable changes to this project will be documented in this file.  
This project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.2.2...HEAD)

### Fixed
 - BINARY/VARBINARY deserialization ([#56](https://github.com/shyiko/mysql-binlog-connector-java/issues/56)).  
This is **BACKWARD-INCOMPATIBLE** change as CHAR/VARCHAR/BINARY/VARBINARY are now returned as `byte[]` (which you can obviously convert to String with `new String(byte[], Charset)`). 

## [0.2.2](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.2.1...0.2.2) - 2015-07-10

### Fixed
 - TIMESTAMP_V2 deserialization ([#46](https://github.com/shyiko/mysql-binlog-connector-java/pull/46)).
 - Freeze during `BinaryLogClient.connect` in case of missing `REPLICATION CLIENT` permission ([#55](https://github.com/shyiko/mysql-binlog-connector-java/pull/55)).

## [0.2.1](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.2.0...0.2.1) - 2015-05-19

### Changed
- `SocketFactory.createSocket` method signature by adding `throws SocketException`.

### Fixed
- Initial handshake error reporting (so that actual message received from the server wouldn't be lost).
- Risk of BinaryLogClient getting stuck while in "pre-close" state.

## [0.2.0](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.1.3...0.2.0) - 2015-05-01
### Added
- Support for COM_BINLOG_DUMP_GTID (`BinaryLogClient`::[gtidSet](https://github.com/shyiko/mysql-binlog-connector-java/commit/3f30768791ef61ab0a83bd2bdb98af80bc799abd#diff-7addc4e3eed6e9254e088abc015ac8adR229)) ([#41](https://github.com/shyiko/mysql-binlog-connector-java/issues/41)).
- Support for authentication via empty password ([#39](https://github.com/shyiko/mysql-binlog-connector-java/issues/39)).

### Changed
- Server error reporting ([#37](https://github.com/shyiko/mysql-binlog-connector-java/issues/37)).  
  WARNING: If you are using exception message to identify specific server errors - you'll need to switch to 
  `ServerException`::[errorCode](https://github.com/shyiko/mysql-binlog-connector-java/commit/1817d0ff709c65c31af9236dcc4e50cc3ad1023b#diff-0dff747d57cb3f5f0548be89a81e29f8R37) (as message no longer includes error code).

### Fixed
- `EventHeaderV4Deserializer` eventLength handling ([#35](https://github.com/shyiko/mysql-binlog-connector-java/issues/35)).

## [0.1.3](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.1.2...0.1.3) - 2015-03-30
### Fixed
- Deserialization of `BitSet`s in little-endian ([#34](https://github.com/shyiko/mysql-binlog-connector-java/issues/34)).

## [0.1.2](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.1.1...0.1.2) - 2015-02-17
### Fixed
- TABLE_MAP/ROTATE `EventDataDeserializer`s handling ([#29](https://github.com/shyiko/mysql-binlog-connector-java/issues/29)).

## [0.1.1](https://github.com/shyiko/mysql-binlog-connector-java/compare/0.1.0...0.1.1) - 2014-12-08
### Fixed
- EXT_WRITE_ROWS event data deserialization when binlog_row_image is set to 'minimal' (default is 'full') ([#26](https://github.com/shyiko/mysql-binlog-connector-java/issues/26)).

## 0.1.0 - 2014-06-03
