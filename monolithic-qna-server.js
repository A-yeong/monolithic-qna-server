import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 1, // 동시에 실행할 VU 수
  duration: '1s', // 테스트 지속 시간
};

// 로직 정의
export default function() {

  // 일반 유저 회원가입
  http.post('http://localhost:8080/api/v1/general/sign-up', JSON.stringify({
    userId: 'general',
    pw: 'pw',
    role: 'general',
  }), { headers: { 'Content-Type': 'application/json' } });

  // 전문가 회원가입
  http.post('http://localhost:8080/api/v1/expert/sign-up', JSON.stringify({
    userId: 'expert',
    pw: 'pw',
    role: 'expert',
  }), { headers: { 'Content-Type': 'application/json' } });

  // 일반 유저 로그인
  http.post('http://localhost:8080/api/v1/user/sign-in', JSON.stringify({
    userId: 'general',
    pw: 'pw',
  }), { headers: { 'Content-Type': 'application/json' } });

  // 전문가 로그인
  http.post('http://localhost:8080/api/v1/user/sign-in', JSON.stringify({
    userId: 'expert',
    pw: 'pw',
  }), { headers: { 'Content-Type': 'application/json' } });

  sleep(1);
}
