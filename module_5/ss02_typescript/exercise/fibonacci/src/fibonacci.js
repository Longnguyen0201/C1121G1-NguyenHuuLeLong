function fibonacci(num) {
    if (num <= 1) {
        return 1;
    }
    else {
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
var sum = 0;
for (var i = 0; i < 5; i++) {
    sum += fibonacci(i);
    console.log(fibonacci(i));
}
console.log("T\u1ED5ng s\u1ED1 fibonacci:  ".concat(sum));
