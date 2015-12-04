describe('Equality', function(){

    it('Equality - 1', function(){
        expect(3 + 7 == 10).toBe( true );
    });

    it('Equality - 2', function(){
        expect(3 + 7 == "10").toBe( true );
    });

    it('Equality - 3', function(){
        expect(3 + 7 === 10).toBe( true );
    });

    it('Equality - 4', function(){
        expect(3 + 7 === "10").toBe( false );
    });

    it('Equality - 5', function(){
        expect("3" + "7" == "37").toBe( true );
    });

    it('Equality - 6', function(){
        expect("3" + "7" == 37).toBe( true );
    });

    it('Equality - 7', function(){
        expect("3" + "7" === "37").toBe( true );
    });

    it('"3" + "7" === 37', function(){
        expect("3" + "7" === 37).toBe( false );
    });

    it('"3" + 7 == "37"', function(){
        expect("3" + 7 == "37").toBe( true );
    });

    it('"3" + 7 === 37', function(){
        expect("3" + 7 === 37).toBe( false );
    });

});