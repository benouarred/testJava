describe('About this : ', function(){

    it("'this' inside a method", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + _;
            }
        };
        expect(person.intro()).toBe("Hello, my name is bob");
    });


    it("'this' on unattached function", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var alias = person.intro;

        window.name = 'Peter';

        expect( _ ).toBe("Hello, my name is Peter");
    });


    it("'this' set explicitly", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var message = person.intro.call( _ );
        expect(message).toBe("Hello, my name is Frank");
    });



});