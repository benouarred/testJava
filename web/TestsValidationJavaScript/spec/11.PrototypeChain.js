describe('About prototype chain : ', function(){

    var father = {
        b: 3,
        c: 4
    };

    var child = Object.create(father);
    child.a = 1;
    child.b = 2;

    it("Is there an 'a' and 'b' own property on child ?", function(){
        expect(child.hasOwnProperty('a')).toBe( _ );
        expect(child.hasOwnProperty('b')).toBe( _ );
    });

    it("Is there an 'a' and 'b' property on child?", function () {
        expect(child.a).toBe( _ );
        expect(child.b).toBe( _ );
    });

    it("If 'b' was removed, whats b value ?", function () {
        delete child.b;
        expect(child.b).toBe( _ );
    });

    it("Is there a 'c' own property on child ?", function () {
        expect(child.hasOwnProperty('c')).toBe( _ );
    });

    it("Is there a 'c' property on child ?", function () {
        expect(child.c).toBe( _ );
    });

    it("Is there an 'd' property on child?", function () {
        expect(child.d).toBe( _ );
    });


});