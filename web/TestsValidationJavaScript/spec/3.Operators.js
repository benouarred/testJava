describe('Operators', function(){

    it('Operators - 1', function(){
        var result = 0;
        for (var i = 0; i <= 3; i++) {
            result = result + i;
        }
        expect(result).toBe(6);
    });

    it('Operators - 2', function(){
        var result = 0;
        for (var i = 0; i <= 3; i++) {
            result += i;
        }
        expect(result).toBe(6);
    });

    it('Operators - 3', function(){
        var result = 3;
        for (var i = 0; i <= 2; i++) {
            result = result - i;
        }
        expect(result).toBe(0);
    });

    it('Operators - 4', function(){
        var result = 3;
        for (var i = 0; i <= 2; i++) {
            result -= i;
        }
        expect(result).toBe(0);
    });

    it('Operators - 5', function(){
        var result = 11;
        var x = 5;
        result %= x;
        expect(result).toBe(1);
    });

});