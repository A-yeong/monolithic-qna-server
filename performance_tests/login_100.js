import { login } from './userLogin.js';
import { sleep } from 'k6';

export const options = {
  vus: 100, // 1초 동안 100명의 VU가 각각 1번의 요청을 보냄
  duration: '1s', // 테스트 지속 시간
};

export default function() {
  for (let i = 0; i < 100; i++) {
    login('general', 'pw');
  }

  sleep(0.01); // 잠시 대기, 여러 요청이 빠르게 발생하도록
}