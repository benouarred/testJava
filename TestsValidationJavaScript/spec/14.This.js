describe('About this : ', function(){

    it("'this' inside a method", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        }
        expect(person.intro()).toBe( _ );
    });


    it("'this' on unattached function", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        }

        var alias = person.intro;

        window._ = 'Peter';
        expect(alias()).toBe("Hello, my name is Peter");
    });


    it("'this' set explicitly", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        }

        var message = person.intro.call({ _ : "Frank"});
        expect(message).toBe("Hello, my name is Frank");
    });



});