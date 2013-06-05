describe('About control structures : ', function(){

    it('if', function(){
        var result = false;
        if (2 > 0) {
            result = true;
        }
        expect(result).toBe( _ );
    });

    it('for', function(){
        var counter = 10;
        for (var i = 1; i <= 3; i++) {
            counter = counter + i;
        }
        expect(counter).toBe( _ );
    });

    it('ternary operator', function(){
        var fruit = true ? "orange" : "banana";
        expect(fruit).toBe( _ );
    });

    it('switch 1', function(){
        var result = 0;
        switch (2) {
            case 1:
                result = 1;
                break;
            case 1+1:
                result = 2;
                break;
        }
        expect(result).toBe( _ );
    });

    it('switch 2', function(){
        var result = "Pippin";
        switch ("m") {
            case "f":
                result = "Frodo";
                break;
            case "s":
                result = "Samwise";
                break;
            default:
                result = "Merry";
                break;
        }
        expect(result).toBe( _ );
    });

    it('switch 3', function(){
        var result = "Pippin";
        switch ("s") {
            case "f":
                result = "Frodo";
                break;
            case "s":
                result = "Samwise";
            default:
                result = "Merry";
                break;
        }
        expect(result).toBe( _ );
    });


    it('null coalescing', function(){
        var fruit = null || "banana";
        expect(fruit).toBe( _ );

        var myFavouriteFruit = fruit || "apple";
        expect(myFavouriteFruit).toBe( _ );
    })

});