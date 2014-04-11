describe('Equality', function(){

    it('Equality - 1', function(){
        expect(3 + 7 == 10).toBe( _ );
    });

    it('Equality - 2', function(){
        expect(3 + 7 == "10").toBe( _ );
    });

    it('Equality - 3', function(){
        expect(3 + 7 === 10).toBe( _ );
    });

    it('Equality - 4', function(){
        expect(3 + 7 === "10").toBe( _ );
    });

    it('Equality - 5', function(){
        expect("3" + "7" == "37").toBe( _ );
    });

    it('Equality - 6', function(){
        expect("3" + "7" == 37).toBe( _ );
    });

    it('Equality - 7', function(){
        expect("3" + "7" === "37").toBe( _ );
    });

    it('"3" + "7" === 37', function(){
        expect("3" + "7" === 37).toBe( _ );
    });

    it('"3" + 7 == "37"', function(){
        expect("3" + 7 == "37").toBe( _ );
    });

    it('"3" + 7 === 37', function(){
        expect("3" + 7 === 37).toBe( _ );
    });

});