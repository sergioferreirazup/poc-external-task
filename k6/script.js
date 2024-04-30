import http from 'k6/http'
import { check, sleep } from 'k6'
import { randomString } from 'https://jslib.k6.io/k6-utils/1.2.0/index.js'
export const options = {
    vus: 100,
    duration: '10s',
};

export default function () {
    const payload = JSON.stringify({
        variables: {},
        businessKey: randomString(5),
        withVariablesInReturn: true
    })
    const params = {
        headers: {
            'Content-Type': 'application/json',
        }
    }
    let res = http.post('http://localhost:8080/engine-rest/process-definition/key/poc_external/start', payload, params)

    check(res, { 'success login': (r) => r.status === 200 })

    sleep(0.3)
}
