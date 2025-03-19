import http from 'k6/http';

// 로그인 함수 (일반 유저 및 전문가 공통)
export function login(userId, pw) {
  const url = 'http://localhost:8080/api/v1/user/sign-in';
  const payload = JSON.stringify({ userId, pw });
  const params = { headers: { 'Content-Type': 'application/json' } };
  http.post(url, payload, params);
}