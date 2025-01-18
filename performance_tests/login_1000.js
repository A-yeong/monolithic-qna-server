import { login } from './userLogin.js';
import { sleep } from 'k6';

export const options = {
  vus: 100,
  duration: '1s',
};

export default function() {
  for (let i = 0; i < 5; i++) {
    login('general', 'pw');
  }

  sleep(0.5);
}