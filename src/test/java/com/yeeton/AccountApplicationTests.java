package com.yeeton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountApplicationTests {


	@Test
	public void setCookie(){
		String cookie = "CXID=B4F0DB6C4A3C2D638072D752AB986497; SUV=002401EA72F15C77592E919AA2426497; sw_uuid=6215024991; sg_uuid=4838326546; ssuid=4822374560; dt_ssuid=5920763228; ABTEST=7|1497229116|v1; weixinIndexVisited=1; ld=Nlllllllll2B5WN$lllllV6diLolllllWTvKMkllll9lllllRllll5@@@@@@@@@@; LSTMV=263%2C25; LCLKINT=940; IPLOC=CN1100; SNUID=3C4FA0AED4D1870EA0E3A0EED5D3124D; JSESSIONID=aaaoF_nM8FKbRg11lW2Yv; sct=9; ad=E7paSlllll2B9SyXlllllVOUz9YlllllLsOJpZllll9lllll4ylll5@@@@@@@@@@; SUID=1B49F9DA5B68860A591114270009FEC7; ppinf=5|1498706982|1499916582|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MjAxN3x1bmlxbmFtZToxODolRTYlQjUlQjclRTUlQjMlQjB8Y3J0OjEwOjE0OTg3MDY5ODJ8cmVmbmljazoxODolRTYlQjUlQjclRTUlQjMlQjB8dXNlcmlkOjQ0Om85dDJsdUtaYlU1LWlfazI2RVYtODNrMjlkMWtAd2VpeGluLnNvaHUuY29tfA; pprdig=jRRieDz5gBznwgcGUkl6-bMuBLtr4du75bUOMk0quVXWhhZsxS2STcsgteCoF9iQmho0rSYFRG4M9zuX59A9HdZs3paDyfO0YYK1Y5Hn8BRiwFXIKduV1ZdqXnvWtw57S8rfBcuLO0bZuP_KDIuQcmt2G96V3JTdceAMI7r50MQ; sgid=17-29361701-AVlUdCZ6mgadToibuHnUdicyE; ppmdig=1498706982000000c91d2f080932a070fcd0163fb364e6a7";
		String[] cookies = cookie.split(";");
		for (String s : cookies) {
			System.out.println(s);
		}
	}


}
