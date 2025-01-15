import http from 'k6/http';

// 일반 유저 회원가입
export function generalSignUp(userId, pw) {
  const url = 'http://localhost:8080/api/v1/general/sign-up';
  const payload = JSON.stringify({ userId, pw, role: 'general' });
  const params = { headers: { 'Content-Type': 'application/json' } };
  http.post(url, payload, params);
}

// 전문가 회원가입
export function expertSignUp(userId, pw) {
  const url = 'http://localhost:8080/api/v1/expert/sign-up';
  const payload = JSON.stringify({ userId, pw, role: 'expert' });
  const params = { headers: { 'Content-Type': 'application/json' } };
  http.post(url, payload, params);
}