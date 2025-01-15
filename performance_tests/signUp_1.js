import { generalSignUp, expertSignUp } from './userSignUp.js';
import { sleep } from 'k6';

export const options = {
  vus: 1, // 1명의 VU만 실행
  duration: '1s', // 테스트 지속 시간
};

export default function() {
  // 일반 유저 회원가입 1번
  generalSignUp('general', 'pw');

  // 전문가 회원가입 1번
  expertSignUp('expert', 'pw');

  sleep(1);
}