import {Directive, ElementRef, HostListener, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appCustomdirective]'
})


export class  CustomdirectiveDirective {
  constructor(private elRef: ElementRef) {
  }

  @HostListener('mouseover') onMouseOver() {
    this.changeBackgroundColor('darkgrey');
  }
  @HostListener('mouseleave') onMouseLeave() {
    this.changeBackgroundColor('white');
  }
  private changeBackgroundColor(color: string) {
    this.elRef.nativeElement.style.backgroundColor = color;
  }
}

