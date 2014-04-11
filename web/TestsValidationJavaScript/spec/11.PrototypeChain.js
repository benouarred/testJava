describe('Prototype chain', function(){

    var father = {
        b: 3,
        c: 4
    };

    var child = Object.create(father);
    child.a = 1;
    child.b = 2;

    it("Prototype chain - 1", function(){
        expect(child.hasOwnProperty('a')).toBe( _ );
        expect(child.hasOwnProperty('b')).toBe( _ );
    });

    it("Prototype chain - 2", function () {
        expect(child.a).toBe( _ );
        expect(child.b).toBe( _ );
    });

    it("Prototype chain - 3", function () {
        delete child.b;
        expect(child.b).toBe( _ );
    });

    it("Prototype chain - 4", function () {
        expect(child.hasOwnProperty('c')).toBe( _ );
    });

    it("Prototype chain - 5", function () {
        expect(child.c).toBe( _ );
    });

    it("Prototype chain - 6", function () {
        expect(child.d).toBe( _ );
    });


});