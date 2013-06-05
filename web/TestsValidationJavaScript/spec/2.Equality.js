describe('About equality : ', function(){

    it('3 + 7 == 10', function(){
        expect(3 + 7 == 10).toBe( _ );
    });

    it('3 + 7 == "10"', function(){
        expect(3 + 7 == "10").toBe( _ );
    });

    it('3 + 7 === 10', function(){
        expect(3 + 7 === 10).toBe( _ );
    });

    it('3 + 7 === "10"', function(){
        expect(3 + 7 === "10").toBe( _ );
    });

    it('"3" + "7" == "37"', function(){
        expect("3" + "7" == "37").toBe( _ );
    });

    it('"3" + "7" == 37', function(){
        expect("3" + "7" == 37).toBe( _ );
    });

    it('"3" + "7" === "37"', function(){
        expect("3" + "7" === "37").toBe( _ );
    });

    it('"3" + "7" === 37', function(){
        expect("3" + "7" === 37).toBe( _ );
    });

    it('"3" + 7 == "37"', function(){
        expect("3" + 7 == "10").toBe( _ );
    });

    it('"3" + 7 === 37', function(){
        expect("3" + 7 === 37).toBe( _ );
    });

});