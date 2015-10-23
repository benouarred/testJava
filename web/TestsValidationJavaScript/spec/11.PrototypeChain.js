describe('Prototype chain', function(){

    var father = {
        b: 3,
        c: 4
    };

    var child = Object.create(father);
    child.a = 1;
    child.b = 2;

    it("Prototype chain - 1", function(){
        expect(child.hasOwnProperty('a')).toBe(true);
        expect(child.hasOwnProperty('b')).toBe(true);
    });

    it("Prototype chain - 2", function () {
        expect(child.a).toBe(1);
        expect(child.b).toBe(2);
    });

    it("Prototype chain - 3", function () {
        delete child.b;
        expect(child.b).toBe(3);
    });

    it("Prototype chain - 4", function () {
        expect(child.hasOwnProperty('c')).toBe(false);
    });

    it("Prototype chain - 5", function () {
        expect(child.c).toBe(4);
    });

    it("Prototype chain - 6", function () {
        expect(child.d).toBe(undefined);
    });


});