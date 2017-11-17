namespace java com.sogou.ts
enum Female{
	MALE,
	FEAMLE,
}

struct People{
	1: required string name;
	2: required i32 age;
	3: required string sex;
}

exception RequestException {
    1: required i32 code;
    2: optional string reason;
}

service HelloWorldService{
	string sayHello(1: string name, 2: string sex) throws (1: RequestException ex);
	oneway void tst();
}