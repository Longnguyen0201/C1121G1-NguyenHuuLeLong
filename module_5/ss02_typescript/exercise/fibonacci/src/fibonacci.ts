function fibonacci(num: number):any {
    if (num <=1){
        return 1;
    }else {
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}

let sum = 0 ;
for (let i = 0 ;i < 5; i++ ){
    sum += fibonacci(i);
    console.log(fibonacci(i))
}
console.log(`Tổng số fibonacci:  ${sum}`);

